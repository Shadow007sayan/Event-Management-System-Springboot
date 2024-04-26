package com.project.EventManagement.Controller;

import com.project.EventManagement.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("ticket/")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("save")
    @PutMapping("event/{eventid}/user/{userid}")
    public String updateEventLocationById(@PathVariable Integer eventid, @PathVariable Integer userid){
        return ticketService.saveTicket(eventid, userid);
    }
}
