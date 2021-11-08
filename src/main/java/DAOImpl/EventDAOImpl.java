package DAOImpl;

import DAO.EventDAO;
import Utils.HibernateSessionFactory;
import Entities.Event;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EventDAOImpl implements EventDAO {

    @Override
    public void addEvent(Event event) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(event);
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
    public void updateEvent(Event event) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(event);
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
    public void deleteEvent(Event event) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(event);
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
    public Event getEventById(int id) {
        Session session = null;
        Event event = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            event = session.get(Event.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при получении!");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return event;
    }


    @Override
    public List<Event> getAllEvents() {
        Session session = null;
        List<Event> eventList = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT * FROM Event";
            Query query = session.createNativeQuery(sql).addEntity(Event.class);
            eventList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при получении!");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return eventList;
    }
}
