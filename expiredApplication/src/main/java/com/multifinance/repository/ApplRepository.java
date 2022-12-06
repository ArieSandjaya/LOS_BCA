package com.multifinance.repository;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.multifinance.model.ApplModel;


@Repository
public interface ApplRepository  extends JpaRepository<ApplModel, Long> {

}
