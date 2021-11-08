package DAO;

import Entities.Event;

import java.util.List;

public interface EventDAO {

    public void addEvent(Event event);

    public void updateEvent(Event event);

    public void deleteEvent(Event event);

    public Event getEventById(int id);

   public List<Event> getAllEvents();

}