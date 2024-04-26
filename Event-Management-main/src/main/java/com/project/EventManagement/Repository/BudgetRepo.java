package com.project.EventManagement.Repository;

import com.project.EventManagement.Model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepo extends JpaRepository<Budget,Integer> {
}
