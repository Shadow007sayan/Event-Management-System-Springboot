package com.project.EventManagement.Repository;

import com.project.EventManagement.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event,Integer> {
    List<Event> findByEventDate(LocalDate Date);
}
