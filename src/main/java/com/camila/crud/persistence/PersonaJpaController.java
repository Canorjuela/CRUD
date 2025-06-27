package com.camila.crud.persistence;

import com.camila.crud.model.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonaJpaController {

    private EntityManagerFactory emf;

    public PersonaJpaController(){
        this.emf= Persistence.createEntityManagerFactory("PersistenciaEjemplo");
    }
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public void create(Persona perso ){
        EntityManager em= getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(perso);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

    public Persona findPersona (int id){
        EntityManager em= getEntityManager();
        try{
            return  em.find(Persona.class, id);
        }
        finally {
            em.close();
        }
    }

    public List<Persona> findPersonas(){
        EntityManager em=getEntityManager();
        try{
            return em.createQuery("SELECT p FROM Persona p ",Persona.class).getResultList();
        }
        finally {
            em.close();
        }
    }

    public void edit (Persona perso){
        EntityManager em= getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(perso);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

    public void destroy (int id){
        EntityManager em= getEntityManager();
        try {
            em.getTransaction().begin();
            Persona perso = em.find(Persona.class, id);
            if (perso != null){
                em.remove(perso);
            }
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

}
