package com.multifinance.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multifinance.model.NtfeModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface NtfeRepository extends JpaRepository<NtfeModel, Long> {

	@Query(value = "SELECT id,ntfe_id,name,description, subject,body,created_at,created_by,updated_at,updated_by FROM multifinance.ntfe WHERE name = 'akan expired'", nativeQuery = true)
	NtfeModel GetEmailText();
	@Query(value = "SELECT id,ntfe_id,name,description, subject,body,created_at,created_by,updated_at,updated_by FROM multifinance.ntfe WHERE name = 'pinjaman-dibatalkan'", nativeQuery = true)
	NtfeModel GetBatalPinjamEmail();
	@Query(value = "SELECT id,ntfe_id,name,description, subject,body,created_at,created_by,updated_at,updated_by FROM multifinance.ntfe WHERE name = 'sudah expired'", nativeQuery = true)
	NtfeModel GetExpiredPinjaman();
}
