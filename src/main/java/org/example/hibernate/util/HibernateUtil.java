package org.example.hibernate.util;

import org.example.hibernate.model.FightingStadion;
import org.example.hibernate.model.Owner;
import org.example.hibernate.model.Pokeball;
import org.example.hibernate.model.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class HibernateUtil {


    private static HibernateUtil hibernateUtil;
    private SessionFactory sessionFactory;
    private ArrayDeque<Session> sessions = new ArrayDeque<>();

    private HibernateUtil() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.setPhysicalNamingStrategy(new CustomNamingStrategy());
            configuration.addAnnotatedClass(Pokemon.class);
            configuration.addAnnotatedClass(Owner.class);
            configuration.addAnnotatedClass(FightingStadion.class);
            configuration.addAnnotatedClass(Pokeball.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory=configuration.buildSessionFactory(builder.build());

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session getSession(){
        Session session;
        if(sessions==null){
            sessions=new ArrayDeque<>();
            session=sessionFactory.openSession();
            sessions.addLast(session);
        }else {
            if (sessions.isEmpty()) {
                session = sessionFactory.openSession();
                sessions.addLast(session);
            }else if(sessions.getLast()!=null){
                session=(Session) sessions.getLast();
            }
            else {
                session = sessionFactory.openSession();
                sessions.addLast(session);
            }
        }
        return session;
    }

    public static HibernateUtil getHibernateUtil(){
        if(hibernateUtil == null){
             hibernateUtil=new HibernateUtil();

        }
        return hibernateUtil;
    }




}
