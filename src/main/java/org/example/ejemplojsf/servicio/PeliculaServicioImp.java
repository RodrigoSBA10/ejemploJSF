package org.example.ejemplojsf.servicio;
import org.example.ejemplojsf.modelo.Pelicula;
import org.example.ejemplojsf.repositorio.RepoPelicula;
import org.example.ejemplojsf.repositorio.RepoPeliculaImp;
import java.util.List;

// Logica de negocio

public class PeliculaServicioImp implements PeliculaServicio{

    public RepoPelicula repoPelicula;

    public PeliculaServicioImp() {
        repoPelicula = new RepoPeliculaImp();
    }


    @Override
    public List<Pelicula> consultarPeliculas() {
        return repoPelicula.getPeliculas();
    }

    @Override
    public Pelicula agregarPelicula(Pelicula p) {
        return repoPelicula.addPelicula(p);
    }

    @Override
    public boolean borrarPelicula(Pelicula p) {
        return  repoPelicula.deletePelicula(p);
    }

    @Override
    public void actualizarPelicula(Pelicula p) {
        repoPelicula.updatePelicula(p);
    }

    @Override
    public Pelicula buscarPelicula(Pelicula p) {
        return repoPelicula.searchPelicula(p);
    }

    @Override
    public Pelicula busvarPeliculaTitulo(String titulo) {
        return repoPelicula.searchPeliculaTitulo(titulo);
    }

    @Override
    public List<Pelicula> consultarPeliculasDuracionMayor(float duracion) {
        return repoPelicula.searchPeliculasDuracionCriteria(duracion);
    }

    @Override
    public List<Pelicula> buscarPeliculaGeneroDuracion(String genero, float duracion) {
        return repoPelicula.searchGenerDuration(genero, duracion);
    }

    @Override
    public float obtenerPromedioDuracion() {
        return repoPelicula.getDurationProm();
    }

    @Override
    public void borrarPeliculaid(int id) {
        repoPelicula.deleteMOvie(id);
    }


}
