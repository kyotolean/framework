package org.example.lab6;


import org.example.lab6.Entities.PersonEntity;
import org.hibernate.Session;

import static org.example.lab6.HibernateUtil.getSessionFactory;

public class Main {
    public static void main(String[] args) {
        PersonEntity person = new PersonEntity("Bob", 28);


        PersonEntity personEntity = new PersonEntity("Miky", 26);

        Session session = getSessionFactory().getCurrentSession();

        session.beginTransaction();
        //create
        Long id = (Long) session.save(person);
        session.save(personEntity);

        //read
        PersonEntity dataForRead = session.get(PersonEntity.class, id);
        System.out.println(dataForRead);

        //update
        dataForRead.setName("John");
        dataForRead.setAge(39);
        session.saveOrUpdate(dataForRead);

        //delete
        session.delete(dataForRead);

        session.getTransaction().commit();

        session.close();
        System.exit(0);
    }
}
