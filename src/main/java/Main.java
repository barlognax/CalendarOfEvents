import DAOImpl.EventDAOImpl;
import DAOImpl.CalendarOfEventDAOimpl;
import Entities.Event;
import Entities.CalendarOfEvent;

import Utils.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static LocalDate date;
    private static LocalTime startTime;
    private static LocalTime endTime;

    public static void main(String[] args) {
        EventDAOImpl eventDAO = new EventDAOImpl();
        CalendarOfEventDAOimpl calendarDAO = new CalendarOfEventDAOimpl();

        //CREATE event
        date = DateTimeFormat.dateFormat("03.09.2021");
        startTime = DateTimeFormat.timeFormat("18:00");
        endTime = DateTimeFormat.timeFormat("21:00");
        CalendarOfEvent calendarOfEvent = new CalendarOfEvent(date, startTime, endTime);
        List<CalendarOfEvent> calendarOfEventList = new ArrayList<>();
        calendarOfEventList.add(calendarOfEvent);
        Event event = new Event("Party", calendarOfEventList);
        eventDAO.addEvent(event);

        //UPDATE event
        date = DateTimeFormat.dateFormat("04.09.2021");
        startTime = DateTimeFormat.timeFormat("19:00");
        endTime = DateTimeFormat.timeFormat("22:00");
        CalendarOfEvent calendarOfEventNew = new CalendarOfEvent(date, startTime, endTime);
        calendarOfEventList.add(calendarOfEventNew);
        event.setCalendarOfEventList(calendarOfEventList);
        eventDAO.updateEvent(event);

        //CREATE new event
        date = DateTimeFormat.dateFormat("05.09.2021");
        startTime = DateTimeFormat.timeFormat("09:00");
        endTime = DateTimeFormat.timeFormat("18:00");
        CalendarOfEvent calendarOfEventWork = new CalendarOfEvent(date, startTime, endTime);
        List<CalendarOfEvent> calendarOfEventWorkList = new ArrayList<>();
        calendarOfEventWorkList.add(calendarOfEventWork);
        Event eventNew = new Event("Work", calendarOfEventWorkList);
        eventDAO.addEvent(eventNew);

        //READ
        List<CalendarOfEvent> listOfCalendar = calendarDAO.getAllCalendar();
        for (CalendarOfEvent c : listOfCalendar) {
            System.out.println(c);
        }
        List<Event> listOfEvents = eventDAO.getAllEvents();
        for (Event e : listOfEvents) {
            System.out.println(e);
        }

        //DELETE
        Event eventForDelete = eventDAO.getEventById(1);
        eventDAO.deleteEvent(eventForDelete);
    }
}



