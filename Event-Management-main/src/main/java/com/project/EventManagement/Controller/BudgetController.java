package com.project.EventManagement.Controller;

import com.project.EventManagement.Service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("budget/")
public class BudgetController {
    @Autowired
    BudgetService budgetService;
    @PutMapping("event/id/{id}/total/{total}/allocated/{allocated}")
    public String updateEventLocationById(@PathVariable Integer id, @PathVariable Integer total,@PathVariable Integer allocated){
        return budgetService.updateBudgetById(id,total,allocated);
    }
}
