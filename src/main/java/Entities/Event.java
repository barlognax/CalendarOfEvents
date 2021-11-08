package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch =FetchType.EAGER)
    @JoinColumn(name="event_id")
    private List<CalendarOfEvent> calendarOfEventList;

    public Event() {
    }

    public Event(String name, List<CalendarOfEvent> calendarOfEventList) {
        this.name = name;
        this.calendarOfEventList = calendarOfEventList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CalendarOfEvent> getCalendarOfEventList() {
        return calendarOfEventList;
    }

    public void setCalendarOfEventList(List<CalendarOfEvent> calendarOfEventList) {
        this.calendarOfEventList = calendarOfEventList;
    }

    public List<CalendarOfEvent> getCalendarByEvent(){
        return calendarOfEventList;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
