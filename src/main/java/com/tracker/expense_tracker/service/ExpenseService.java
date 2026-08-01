package com.tracker.expense_tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.expense_tracker.exception.ExpenseNotFoundException;
import com.tracker.expense_tracker.model.Expense;
import com.tracker.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Add Expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Get All Expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get Expenses by Category
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }

    // Calculate Overall Total
    public Double getTotalExpenses() {
        return expenseRepository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // Calculate Category Total
    public Double getTotalExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category)
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // Delete Expense
    public void deleteExpense(Long id) {

        boolean deleted = expenseRepository.delete(id);

        if (!deleted) {
            throw new ExpenseNotFoundException("Expense with ID " + id + " not found");
        }
    }
}