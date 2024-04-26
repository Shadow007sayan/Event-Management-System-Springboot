package com.project.EventManagement.Service;

import com.project.EventManagement.Model.Event;
import com.project.EventManagement.Model.Ticket;
import com.project.EventManagement.Model.User;
import com.project.EventManagement.Repository.EventRepo;
import com.project.EventManagement.Repository.TicketRepo;
import com.project.EventManagement.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    EventRepo eventRepo;
    @Autowired
    UserRepo userRepo;

    public String saveTicket (Integer eventId,Integer userId){
        Ticket ticket=new Ticket();
        ticket.setDate(new Date());
        Optional<Event> s = eventRepo.findById(eventId);
        ticket.setEvent(s.get());
        Optional<User> t = userRepo.findById(userId);
        ticket.setUser(t.get());
         ticketRepo.save(ticket);

         return "Ticket generated";
    }
}
