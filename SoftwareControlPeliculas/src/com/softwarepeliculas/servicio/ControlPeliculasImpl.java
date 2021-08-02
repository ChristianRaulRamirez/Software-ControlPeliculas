package com.softwarepeliculas.servicio;

import com.softwarepeliculas.datos.AccesoDatosImpl;
import com.softwarepeliculas.datos.IAccesoDatos;
import com.softwarepeliculas.domain.Pelicula;
import com.softwarepeliculas.excepciones.AccesoDatosExcepcion;
import java.util.List;

public class ControlPeliculasImpl implements IControlPeliculas {

    private final IAccesoDatos datos;

    public ControlPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;

        try {
            anexar = datos.comprobarSiExisteArchivo(NOMBRE_RECURSO); //si anexar es true , existe el archivo , de lo contrario si es false no existe
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosExcepcion excepcion) {
            System.out.println("\nError de acceso a datos");
            excepcion.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("Pelicula : " + pelicula);
            }
        } catch (AccesoDatosExcepcion excepcion) {
            System.out.println("\nError de acceso a datos");
            excepcion.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String PeliculaABuscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, PeliculaABuscar);
        } catch (AccesoDatosExcepcion excepcion) {
            System.out.println("\nError de acceso a datos");
            excepcion.printStackTrace(System.out);
        }

        if (resultado == null) {
            System.out.println("No se ha encontrado la pelicula . ");
        } else {
            System.out.println("Pelicula encontrada : " + resultado);
        }
    }

    @Override
    public void iniciarControlDePeliculas() {
        //este método elimina y crea un archivo texto 
        try {
            if (this.datos.comprobarSiExisteArchivo(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosExcepcion excepcion) {
            System.out.println("\nError al iniciar control de peliculas");
            excepcion.printStackTrace(System.out);
        }
    }

}
