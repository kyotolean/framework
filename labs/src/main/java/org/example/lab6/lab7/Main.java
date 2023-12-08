package org.example.lab6.lab7;

import org.example.lab6.Entities.Friend;
import org.example.lab6.Entities.PersonEntity;
import org.example.lab6.Entities.SocialMedia;
import org.example.lab6.Entities.University;
import org.example.lab6.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        PersonEntity person = new PersonEntity("Miky", 27);


        //added University entity to person for oneToOne
        //OneToOne
        person.setUniversity(new University("IT Step"));
        Long id = (Long) session.save(person);
        System.out.println("OneToOne: " + session.get(PersonEntity.class, id));
        //OneToMany
        person.setFriend(Arrays.asList(new Friend("Bob"), new Friend("Mash"), new Friend("David")));
        session.saveOrUpdate(person);
        System.out.println("OneToMany: " + session.get(PersonEntity.class, id));
        //ManyToMany
        //added socialMedia for many-to-many
        PersonEntity personEntity = new PersonEntity("Bob", 41);
        SocialMedia telegram = new SocialMedia("Telegram");
        SocialMedia viber = new SocialMedia("Viber");

        Long id2 = (Long) session.save(personEntity);

        session.save(telegram);
        session.save(viber);

        person.setSocialMedia(Arrays.asList(telegram, viber));
        personEntity.setSocialMedia(Arrays.asList(viber));

        session.saveOrUpdate(person);
        session.saveOrUpdate(personEntity);

        System.out.println("ManyToMany: " + session.get(PersonEntity.class, id));
        System.out.println("ManyToMany: " + session.get(PersonEntity.class, id2));


        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}
