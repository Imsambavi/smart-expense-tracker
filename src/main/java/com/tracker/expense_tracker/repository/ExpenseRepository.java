package com.tracker.expense_tracker.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tracker.expense_tracker.model.Expense;

@Repository
public class ExpenseRepository {

    // In-memory storage
    private final List<Expense> expenses = new ArrayList<>();

    // Auto-increment ID
    private Long nextId = 1L;

    // Save a new expense
    public Expense save(Expense expense) {
        expense.setId(nextId++);
        expenses.add(expense);
        return expense;
    }

    // Return all expenses
    public List<Expense> findAll() {
        return expenses;
    }

    // Find expense by ID
    public Optional<Expense> findById(Long id) {
        return expenses.stream()
                .filter(expense -> expense.getId().equals(id))
                .findFirst();
    }

    // Find expenses by category
    public List<Expense> findByCategory(String category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    // Delete expense
    public boolean delete(Long id) {
        return expenses.removeIf(expense -> expense.getId().equals(id));
    }
}