package com.yeswanth.expensetrackerapi.repository;

import com.yeswanth.expensetrackerapi.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
