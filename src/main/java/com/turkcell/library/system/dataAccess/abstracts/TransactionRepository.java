package com.turkcell.library.system.dataAccess.abstracts;

import com.turkcell.library.system.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
