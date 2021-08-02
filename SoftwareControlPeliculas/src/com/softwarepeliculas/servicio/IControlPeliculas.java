package com.softwarepeliculas.servicio;

public interface IControlPeliculas {

    String NOMBRE_RECURSO = "peliculas.txt";

    public void agregarPelicula(String nombrePelicula);

    public void listarPeliculas();

    public void buscarPelicula(String PeliculaABuscar);

    public void iniciarControlDePeliculas();
}
