package com.multifinance.repository;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.multifinance.model.CustModel;
import com.multifinance.model.UsrProfileModel;

@Repository
public interface UsrProfileRepository extends JpaRepository<UsrProfileModel, String> {

}
