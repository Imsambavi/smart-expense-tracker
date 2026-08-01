package com.tracker.expense_tracker.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.tracker.expense_tracker.exception.ExpenseNotFoundException;
import com.tracker.expense_tracker.model.Expense;
import com.tracker.expense_tracker.repository.ExpenseRepository;

class ExpenseServiceTest {

    private ExpenseRepository repository;

    private ExpenseService service;

    @BeforeEach
    void setup() {
        repository = Mockito.mock(ExpenseRepository.class);
        service = new ExpenseService(repository);
    }

    @Test
    void testAddExpense() {

        Expense expense = new Expense(
                1L,
                "Coffee",
                120.0,
                "Food",
                LocalDate.now());

        when(repository.save(expense)).thenReturn(expense);

        Expense savedExpense = service.addExpense(expense);

        assertEquals("Coffee", savedExpense.getTitle());

        verify(repository).save(expense);
    }

    @Test
    void testGetAllExpenses() {

        List<Expense> expenses = List.of(
                new Expense(
                        1L,
                        "Coffee",
                        120.0,
                        "Food",
                        LocalDate.now()));

        when(repository.findAll()).thenReturn(expenses);

        List<Expense> result = service.getAllExpenses();

        assertEquals(1, result.size());

        verify(repository).findAll();
    }

    @Test
    void testGetExpensesByCategory() {

        List<Expense> food = List.of(
                new Expense(
                        1L,
                        "Pizza",
                        300.0,
                        "Food",
                        LocalDate.now()));

        when(repository.findByCategory("Food")).thenReturn(food);

        List<Expense> result = service.getExpensesByCategory("Food");

        assertEquals(1, result.size());

        assertEquals("Food", result.get(0).getCategory());
    }

    @Test
    void testGetTotalExpenses() {

        List<Expense> expenses = List.of(
                new Expense(1L, "Coffee", 100.0, "Food", LocalDate.now()),
                new Expense(2L, "Movie", 300.0, "Entertainment", LocalDate.now()));

        when(repository.findAll()).thenReturn(expenses);

        Double total = service.getTotalExpenses();

        assertEquals(400.0, total);
    }

    @Test
    void testDeleteExpense() {

        when(repository.delete(1L)).thenReturn(true);

        assertDoesNotThrow(() -> service.deleteExpense(1L));

        verify(repository).delete(1L);
    }

    @Test
    void testDeleteExpenseThrowsException() {

        when(repository.delete(10L)).thenReturn(false);

        assertThrows(
                ExpenseNotFoundException.class,
                () -> service.deleteExpense(10L));
    }
}