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
    private List<Pelicula> peliculasDuracion;
    protected String titulo;
    private Pelicula pelicula;
    private String genero;
    private float duracion;
    private float promedio;
    public PeliculasBean() {
        peliServ=new PeliculaServicioImp();
    }
    public void peliculas(){
        peliculas = peliServ.consultarPeliculas();
    }
    public void buscarDuracion(){
        peliculasDuracion = peliServ.consultarPeliculasDuracionMayor(duracion);
    }
    public void buscarTitulo(){
        pelicula = peliServ.busvarPeliculaTitulo(titulo);
    }
    public void  buscarGeneroDuracion(){
        PpelisGeneroXduracion = peliServ.buscarPeliculaGeneroDuracion(genero, duracion);
    }

    public void eliminarPelicula(){
        if (pelicula!=null){
            peliServ.borrarPeliculaid(pelicula.getId());
            pelicula = null;
        }
    }

    public void agregarPeli(){
        Pelicula nuevaPeli = new Pelicula();
        nuevaPeli.setTitulo(titulo);
        nuevaPeli.setTipo(genero);
        nuevaPeli.setDuracion(duracion);
        peliServ.agregarPelicula(nuevaPeli);
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

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public List<Pelicula> getPeliculasDuracion() {
        return peliculasDuracion;
    }

    public void setPeliculasDuracion(List<Pelicula> peliculasDuracion) {
        this.peliculasDuracion = peliculasDuracion;
    }
}

