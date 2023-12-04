package com.yeswanth.expensetrackerapi.service;

import com.yeswanth.expensetrackerapi.models.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getElementById(Long id);

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);
    Expense updateExpenseDetails(Long id, Expense expense);
}
