package com.softwarepeliculas.presentacion;

import com.softwarepeliculas.servicio.ControlPeliculasImpl;
import com.softwarepeliculas.servicio.IControlPeliculas;
import java.util.Scanner;

public class PresentacionControlPeliculas {

    public static void main(String[] args) {

        IControlPeliculas controlPeliculas = new ControlPeliculasImpl();
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        int opcion;

        System.out.println("--------------------------------");
        System.out.println("Software - Control de películas");
        System.out.println("--------------------------------");

        do {
            System.out.println("\nDigite una opción , por favor : ");
            System.out.println("1 . Iniciar control de películas . ");
            System.out.println("2 . Agregar película . ");
            System.out.println("3 . Lista peliculas . ");
            System.out.println("4 . Buscar película . ");
            System.out.println("5 . Salir");
            System.out.print("Seleccione una opcion : ");
            opcion = teclado.nextInt();

            System.out.println("");
            
            switch (opcion) {
                case 1:
                    controlPeliculas.iniciarControlDePeliculas();
                    break;

                case 2:
                    System.out.print("Digite el nombre de la pelicula : ");
                    String nombrePelicula = teclado.next();
                    controlPeliculas.agregarPelicula(nombrePelicula);
                    System.out.println("Pelicula agregada con exito . ");
                    break;

                case 3:
                    System.out.println("");
                    controlPeliculas.listarPeliculas();
                    break;

                case 4:
                    System.out.println("");
                    System.out.print("Digite la pelicula a buscar : ");
                    String peliculaABuscar = teclado.next();
                    controlPeliculas.buscarPelicula(peliculaABuscar);
                    break;

                case 5:
                    System.out.println("");
                    System.out.println("---------------------------------------");
                    System.out.println("Gracias por participar , hasta pronto !");
                    System.out.println("---------------------------------------");
                    opcion = 5;
                    break;

                default:
                    System.out.println("");
                    System.out.println("----------------------------------------");
                    System.out.println("Opcion no disponible , vuelva a intentar");
                    System.out.println("----------------------------------------");
                    break;
            }
        } while (opcion != 5);
    }

}
