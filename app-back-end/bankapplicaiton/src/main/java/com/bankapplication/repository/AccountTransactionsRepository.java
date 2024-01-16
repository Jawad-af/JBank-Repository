package com.bankapplication.repository;

import com.bankapplication.model.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, Integer> {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
