package org.example.ejemplojsf.repositorio;

import org.example.ejemplojsf.modelo.Pelicula;

import java.util.List;

public interface RepoPelicula {
    List<Pelicula> getPeliculas();
    Pelicula addPelicula(Pelicula p);
    boolean deletePelicula(Pelicula p);
    void updatePelicula(Pelicula p);
    Pelicula searchPelicula(Pelicula p);
    Pelicula searchPeliculaTitulo(String titulo);
    List<Pelicula> searchPeliculasDuracionCriteria(float duracion);
    List<Pelicula> searchGenerDuration(String genero, float duracion);
}
