package DAOImpl;

import DAO.CalendarOfEventDAO;
import Utils.HibernateSessionFactory;
import Entities.CalendarOfEvent;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CalendarOfEventDAOimpl implements CalendarOfEventDAO {

    @Override
    public void addCalendar(CalendarOfEvent calendarOfEvent) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(calendarOfEvent);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при вставке!");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateCalendar(CalendarOfEvent calendarOfEvent) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(calendarOfEvent);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при вставке!");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteCalendar(CalendarOfEvent calendarOfEvent) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(calendarOfEvent);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при удалении!");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public CalendarOfEvent getCalendarById(int id) {
        Session session = null;
        CalendarOfEvent calendarOfEvent = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            calendarOfEvent = session.get(CalendarOfEvent.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при получении!");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return calendarOfEvent;
    }


    @Override
    public List<CalendarOfEvent> getAllCalendar() {
        Session session = null;
        List<CalendarOfEvent> calendarOfEventList = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT * FROM CalendarofEvent";
            Query query = session.createNativeQuery(sql).addEntity(CalendarOfEvent.class);
            calendarOfEventList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при получении!");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return calendarOfEventList;
    }
}



