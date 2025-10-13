package org.example.ejemplojsf.beans;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.example.ejemplojsf.modelo.Pelicula;
import org.example.ejemplojsf.servicio.PeliculaServicio;
import org.example.ejemplojsf.servicio.PeliculaServicioImp;

import java.io.Serializable;
import java.util.List;


@Named ("peliculasbean")
@SessionScoped
public class PeliculasBean implements Serializable {

    private List<Pelicula> peliculas;
    private PeliculaServicio peliServ;
    private List<Pelicula> PpelisGeneroXduracion;
    protected String titulo;
    private Pelicula pelicula;
    private String genero;
    private float duracion;
    public PeliculasBean() {
        peliServ=new PeliculaServicioImp();
        peliculas = peliServ.consultarPeliculas();
        //peliculas = peliServ.consultarPeliculasDuracionMayor(1);
        //peliculas= peliServ.buscarPeliculaGeneroDuracion(genero, duracion);
    }
    public void buscarTitulo(){
        System.out.println(this.titulo);
        pelicula = peliServ.busvarPeliculaTitulo(titulo);
    }
    public void  buscarGeneroDuracion(){
        PpelisGeneroXduracion = peliServ.buscarPeliculaGeneroDuracion(genero, duracion);
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public List<Pelicula> getPpelisGeneroXduracion() {
        return PpelisGeneroXduracion;
    }

    public void setPpelisGeneroXduracion(List<Pelicula> ppelisGeneroXduracion) {
        PpelisGeneroXduracion = ppelisGeneroXduracion;
    }
}

