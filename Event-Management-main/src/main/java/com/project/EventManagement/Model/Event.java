package com.project.EventManagement.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  eventId;

    private String eventName;

    private String locationOfEvent;

    private LocalDate eventDate;

    private LocalTime startTime;

    private LocalTime endTime;

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

    @OneToOne(mappedBy = "eventBudget", cascade = CascadeType.ALL)
    private Budget budget;

}

/*Event Model will have
eventId
eventName
locationOfEvent
date
startTime
endTime*/
