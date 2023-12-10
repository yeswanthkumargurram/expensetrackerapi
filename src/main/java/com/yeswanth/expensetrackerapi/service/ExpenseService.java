package com.yeswanth.expensetrackerapi.service;

import com.yeswanth.expensetrackerapi.models.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);
    Expense getElementById(Long id);

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);
    Expense updateExpenseDetails(Long id, Expense expense);
}
