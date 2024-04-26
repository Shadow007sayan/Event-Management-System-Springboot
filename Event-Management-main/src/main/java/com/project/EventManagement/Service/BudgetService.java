package com.project.EventManagement.Service;

import com.project.EventManagement.Model.Budget;
import com.project.EventManagement.Repository.BudgetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetService {
    @Autowired
    BudgetRepo budgetRepo;

    public String updateBudgetById(Integer id, Integer total,Integer allocated){
        Optional<Budget> s = budgetRepo.findById(id);

        if(s.isEmpty()){
            return "Budget not found !!!";
        }

        Budget e = s.get();
        e.setTotalAmount(total);
        e.setAllocatedAmount(allocated);
        budgetRepo.save(e);
        return "Budget updated for the provided event";
    }
}
