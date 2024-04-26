package com.project.EventManagement.Repository;

import com.project.EventManagement.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket,Integer> {
}
