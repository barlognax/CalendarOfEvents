package DAO;

import Entities.CalendarOfEvent;

import java.util.List;

public interface CalendarOfEventDAO {

    public void addCalendar(CalendarOfEvent calendarOfEvent);

    public void updateCalendar(CalendarOfEvent calendarOfEvent);

    public void deleteCalendar(CalendarOfEvent calendarOfEvent);

    public CalendarOfEvent getCalendarById(int id);

    public List<CalendarOfEvent> getAllCalendar();

}
