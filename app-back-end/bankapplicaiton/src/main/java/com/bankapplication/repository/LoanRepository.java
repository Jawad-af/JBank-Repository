package com.bankapplication.repository;

import com.bankapplication.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Integer> {
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}

