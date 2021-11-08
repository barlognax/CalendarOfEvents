package Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class CalendarOfEvent {
    @Id
    @GeneratedValue
    private int id;

    private LocalDate date;
    private LocalTime starttime;
    private LocalTime endtime;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public CalendarOfEvent() {
    }

    public CalendarOfEvent(LocalDate date, LocalTime starttime, LocalTime endtime) {
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "CalendarOfEvent{" +
                "date=" + date +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }
}
