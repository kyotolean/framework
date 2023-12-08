package db;

import org.hibernate.Session;

import static db.HibernateUtil.getSessionFactory;

public class HibernateHelper {
    public static Session session = getSessionFactory().getCurrentSession();
    public static void startTransaction(){
        session.beginTransaction();
    }
    public static void closeTransaction(){
        session.getTransaction().commit();
        session.close();
    }
}
