package org.example.ejemplojsf.beans;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.example.ejemplojsf.modelo.Pelicula;
import org.example.ejemplojsf.servicio.PeliculaServicio;
import org.example.ejemplojsf.servicio.PeliculaServicioImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named ("peliculasbean")
@SessionScoped
public class peliculasBean implements Serializable {

    private List<Pelicula> peliculas;
    private PeliculaServicio peliServ;
    protected String titulo;
    private Pelicula pelicula;
    public peliculasBean() {
        peliServ=new PeliculaServicioImp();
        peliculas= peliServ.consultarPeliculas();
    }
    public void buscarTitulo(){
        System.out.println(this.titulo);
        pelicula = peliServ.busvarPeliculaTitulo(titulo);
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

