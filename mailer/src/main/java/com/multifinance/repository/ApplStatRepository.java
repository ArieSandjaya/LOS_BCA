package com.multifinance.repository;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.multifinance.model.ApplStatModel;

@Repository
public interface ApplStatRepository extends JpaRepository<ApplStatModel, Long> {
	
	List<ApplStatModel> findAllByStatusBetween(String from, String to);
	
	@Query(value = "SELECT DISTINCT id, appl_stat_id, appl_id, status, comp_id, MAX(created_at) created_at, created_by, update_at, update_by, last_status "
			+ "FROM multifinance.appl_stat "
			+ "WHERE status >= :fromStatus "
			+ "AND status <= :toStatus "
			+ "GROUP BY id, appl_stat_id, appl_id, status, comp_id, created_at, created_by, update_at, update_by, last_status "
			, nativeQuery = true)
	List<ApplStatModel> findAllMaxCreatedAtByStatusBetween(
			@Param("fromStatus") String fromStatus,
			@Param("toStatus") String toStatus
	);

	@Query(value = "SELECT DISTINCT id, appl_stat_id, appl_id, status, comp_id, MIN(created_at) created_at, created_by, update_at, update_by, last_status "
			+ "FROM multifinance.appl_stat "
			+ "WHERE status >= :fromStatus "
			+ "AND status <= :toStatus "
			+ "GROUP BY id, appl_stat_id, appl_id, status, comp_id, created_at, created_by, update_at, update_by, last_status "
			, nativeQuery = true)
	List<ApplStatModel> findAllMinCreatedAtByStatusBetween(
			@Param("fromStatus") String fromStatus,
			@Param("toStatus") String toStatus
	);

}
