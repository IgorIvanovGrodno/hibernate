package org.example.hibernate.model;

import org.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Locale;

public class PokemonLoader {
    public static HibernateUtil util = null;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Pokemon pokemon=new Pokemon("har", "popa", 10);
        Pokeball pokeball=new Pokeball("oval");
        util=HibernateUtil.getHibernateUtil();
        Session session = util.getSession();

        //session.save(pokemon);
        session.save(pokeball);
        System.out.println("Generated############## "+pokemon.getId());
        Transaction tx=session.beginTransaction();
        tx.commit();
       // deleteEntityDB(9L);
        //System.out.println(findEntityDB(1L));
        System.out.println(findOwnerEntityDB(1L));
        System.out.println(findStadionEntityDB(1L));
        session.close();


    }

    public static void deleteEntityDB(Long id){

        Session session = util.getSession();
        Transaction tx = session.beginTransaction();
        Pokemon pokemon = (Pokemon) session.get(Pokemon.class, id);
        session.delete(pokemon);
        tx.commit();
    }

    public static Pokemon findEntityDB(Long id){

        Session session = util.getSession();
        Transaction tx = session.beginTransaction();
        Pokemon pokemon = (Pokemon) session.get(Pokemon.class, id);
        tx.commit();
        return pokemon;
    }
    public static Owner findOwnerEntityDB(Long id){

        Session session = util.getSession();
        Transaction tx = session.beginTransaction();
        Owner owner = (Owner) session.get(Owner.class, id);
        tx.commit();
        return owner;
    }

    public static FightingStadion findStadionEntityDB(Long id){

        Session session = util.getSession();
        Transaction tx = session.beginTransaction();
        FightingStadion fightingStadion = (FightingStadion) session.get(FightingStadion.class, id);
        tx.commit();
        return fightingStadion;
    }
}
