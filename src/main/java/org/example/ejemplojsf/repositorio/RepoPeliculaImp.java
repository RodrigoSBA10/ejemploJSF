package org.example.ejemplojsf.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.ejemplojsf.modelo.Pelicula;

import java.util.List;

public class RepoPeliculaImp implements  RepoPelicula {

    protected EntityManager em;

    public RepoPeliculaImp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("basePeliculas");
        em = emf.createEntityManager();
    }

    @Override
    public List<Pelicula> getPeliculas() {
        TypedQuery<Pelicula> query= em.createQuery("SELECT p FROM Pelicula p",Pelicula.class);
        return query.getResultList();
    }

    @Override
    public Pelicula addPelicula(Pelicula p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    @Override
    public boolean deletePelicula(Pelicula p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        return searchPelicula(p)!=null;
    }

    @Override
    public void updatePelicula(Pelicula p) {
        em.getTransaction().commit();
        em.merge(p);
        em.getTransaction().commit();
    }

    @Override
    public Pelicula searchPelicula(Pelicula p) {
        return em.find(Pelicula.class,p.getId());
    }

    @Override
    public Pelicula searchPeliculaTitulo(String titulo) {
        TypedQuery<Pelicula> consulta = em.createNamedQuery("selectPeliculaTitulo", Pelicula.class);
        consulta.setParameter("titulo", titulo);
        Pelicula pelicula = consulta.getResultList().get(0);
        return pelicula;
    }
}
