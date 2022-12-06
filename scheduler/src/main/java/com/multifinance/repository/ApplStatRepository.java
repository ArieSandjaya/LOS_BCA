package com.multifinance.repository;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.multifinance.model.ApplStatModel;

@Repository
public interface ApplStatRepository extends JpaRepository<ApplStatModel, Long> {
	
//	List<ApplStatModel> findAllByStatusBetween(String from, String to);
	
//	@Query(value = "SELECT DISTINCT id, appl_stat_id, appl_id, status, comp_id, MAX(created_at) created_at, created_by, update_at, update_by, last_status "
//			+ "FROM multifinance.appl_stat "
//			+ "WHERE CAST(status AS integer)  >= :fromStatus "
//			+ "AND CAST(status AS integer) <= :toStatus "
//			+ "GROUP BY id, appl_stat_id, appl_id, status, comp_id, created_at, created_by, update_at, update_by, last_status "
//			+ "HAVING DATE_PART('day', now() - min(created_at)) >= :lngNotif"
//			, nativeQuery = true)
//	List<ApplStatModel> findAllMaxCreatedAtByStatusBetween(
//			@Param("fromStatus") Integer fromStatus,
//			@Param("toStatus") Integer toStatus,
//			@Param("lngNotif") Long lngNotif
//	);

//	@Query(value = "SELECT DISTINCT id, appl_stat_id, appl_id, status, comp_id, MIN(created_at) created_at, created_by, update_at, update_by, last_status "
//			+ "FROM multifinance.appl_stat "
//			+ "WHERE CAST(status AS integer) >= :fromStatus "
//			+ "AND CAST(status AS integer) <= :toStatus "
//			+ "GROUP BY id, appl_stat_id, appl_id, status, comp_id, created_at, created_by, update_at, update_by, last_status "
//			, nativeQuery = true)
//	List<ApplStatModel> findAllMinCreatedAtByStatusBetween(
//			@Param("fromStatus") Integer fromStatus,
//			@Param("toStatus") Integer toStatus
//	);
	
	
	//queries for 3 days notification
	@Query(value = "SELECT DISTINCT max(A.id) id,A.appl_id,  MAX(A.created_at) created_at, A.last_status, " + 
			"date_part('day', now() - coalesce(max(A.update_at),max(A.created_at))) ddiff, " + 
			"B.cust_id, D.username, D.fullname FROM multifinance.appl_stat A " + 
			"inner join multifinance.appl B on A.appl_id = B.id " + 
			"inner join multifinance.cust C on B.cust_id = C.id " +
			"inner join oauth.usr_profile D on cast(C.cust_id as text) = cast(D.id as text) " +
			"WHERE last_status = status AND " +
			"(CAST(last_status AS integer) >= :fromStatus " +
			"AND CAST(last_status AS integer) <= :toStatus) "+ 
			"GROUP BY A.appl_id, last_status, B.cust_id, D.username, D.fullname " + 
			"HAVING date_part('day', now() - coalesce(max(A.update_at),max(A.created_at))) = :applNotif "
			, nativeQuery = true)
	List<ApplStatModel> findAllDraftNotif(
			@Param("fromStatus") Integer fromStatus,
			@Param("toStatus") Integer toStatus,
			@Param("applNotif") Long applNotif
	);
	
	//queries for 23 days expired draft application
		@Query(value = "SELECT DISTINCT max(A.id) id,A.appl_id,  MIN(A.created_at) created_at, A.last_status, " + 
				"date_part('day', now() - MIN(A.created_at)) ddiff, " + 
				"B.cust_id, D.username, D.fullname FROM multifinance.appl_stat A " + 
				"inner join multifinance.appl B on A.appl_id = B.id " + 
				"inner join multifinance.cust C on B.cust_id = C.id " +
				"inner join oauth.usr_profile D on cast(C.cust_id as text) = cast(D.id as text) " +
				"WHERE CAST(last_status AS integer) >= :fromStatus " +
				"AND CAST(last_status AS integer) <= :toStatus "+ 
				"GROUP BY A.appl_id, last_status, B.cust_id, D.username, D.fullname " + 
				"HAVING DATE_PART('day', now() - MIN(A.created_at)) >= :applMax"
				, nativeQuery = true)
		List<ApplStatModel> findAllDraftLifeTimeExpired(
				@Param("fromStatus") Integer fromStatus,
				@Param("toStatus") Integer toStatus,
				@Param("applMax") Long applMax
		);
		
		//queries for 7 days expired draft application
		@Query(value = "SELECT DISTINCT max(A.id) id,A.appl_id,  MAX(A.created_at) created_at, A.last_status, " + 
				"date_part('day', now() - MAX(A.created_at)) ddiff, " + 
				"B.cust_id, D.username, D.fullname FROM multifinance.appl_stat A " + 
				"inner join multifinance.appl B on A.appl_id = B.id " + 
				"inner join multifinance.cust C on B.cust_id = C.id " +
				"inner join oauth.usr_profile D on cast(C.cust_id as text) = cast(D.id as text) " +
				"WHERE CAST(last_status AS integer) >= :fromStatus " +
				"AND CAST(last_status AS integer) <= :toStatus "+ 
				"GROUP BY A.appl_id, last_status, B.cust_id, D.username, D.fullname " + 
				"HAVING DATE_PART('day', now() - MAX(A.created_at)) >= :applIdle"
				, nativeQuery = true)
		List<ApplStatModel> findAllDraftExpired(
				@Param("fromStatus") Integer fromStatus,
				@Param("toStatus") Integer toStatus,
				@Param("applIdle") Long applIdle
		);
		//queries for 7 days expired submit application
		@Query(value = "SELECT DISTINCT max(A.id) id,A.appl_id,  MAX(A.created_at) created_at, A.last_status, " + 
				"date_part('day', now() - MAX(A.created_at)) ddiff, " + 
				"B.cust_id, D.username, D.fullname FROM multifinance.appl_stat A " + 
				"inner join multifinance.appl B on A.appl_id = B.id " + 
				"inner join multifinance.cust C on B.cust_id = C.id " +
				"inner join oauth.usr_profile D on cast(C.cust_id as text) = cast(D.id as text) " +
				"WHERE CAST(last_status AS integer) = :applStatusApproved " +
				"GROUP BY A.appl_id, last_status, B.cust_id, D.username, D.fullname " + 
				"HAVING DATE_PART('day', now() - MAX(A.created_at)) >= :applIdle"
				, nativeQuery = true)
		List<ApplStatModel> findAllSubmitExpired(
				@Param("applIdle") Long applIdle,
				@Param("applStatusApproved") Long applStatusApproved
		);

		@Transactional
		@Modifying
		@Query(value = "UPDATE multifinance.appl_stat SET status = :lastStatus, last_status = :lastStatus, update_by = 0, update_at = :update_at " +
					   "WHERE id = :id"
				, nativeQuery = true)
		void updateApplStatus(
				@Param("lastStatus") String status,
				@Param("id") Long id,
				@Param("update_at") LocalDateTime update_at
		);
		
		@Transactional
		@Modifying
		@Query(value = "UPDATE multifinance.appl_stat SET last_status = :lastStatus, update_at = :update_at " +
				   	   "WHERE appl_id = :applId"
			, nativeQuery = true)
		void updateApplLastStatus(
				@Param("lastStatus") String lastStatus,
				@Param("applId") Long applId,
				@Param("update_at") LocalDateTime update_at
		);
}
