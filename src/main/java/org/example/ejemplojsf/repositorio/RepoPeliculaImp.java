package org.example.ejemplojsf.repositorio;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

    @Override
    public List<Pelicula> searchPeliculasDuracionCriteria(float duracion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Pelicula>  criteria = cb.createQuery(Pelicula.class);
        Root<Pelicula> rootPei = criteria.from(Pelicula.class);
        criteria.select(rootPei);
        criteria.where(cb.greaterThan(rootPei.get("duracion"), duracion));
        List<Pelicula> resultado = em.createQuery(criteria).getResultList();
        return resultado;
    }

    @Override
    public List<Pelicula> searchGenerDuration(String genero, float duracion) {
        String sentencia = "SELECT * FROM peliculas WHERE  genero=?1 AND duracion>?2";
        Query query =  em.createNativeQuery(sentencia, Pelicula.class);
        query.setParameter(1,genero);
        query.setParameter(2,duracion);
        return query.getResultList();
    }
}
