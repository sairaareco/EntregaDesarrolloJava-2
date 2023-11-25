package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Libro> listaLibros = new ArrayList<>();
        List<Usuario> listaUsuarios = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(listaLibros, listaUsuarios);

        Libro libro1 = new Libro("El Psicoanalista", "John Katzenbach", "Thriller");
        biblioteca.agregarLibro(libro1);

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("BIENVENIDO A LA BIBLIOTECA");
            System.out.println("1. Agregar nuevo libro");
            System.out.println("2. Alquilar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Registrar nuevo usuario");
            System.out.println("5. Ver libros en la biblioteca");
            System.out.println("6. Salir");
            System.out.print("Ingrese el número de la opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del nuevo libro: ");
                    String tituloLibro = scanner.nextLine();
                    System.out.print("Ingrese el autor del nuevo libro: ");
                    String autorLibro = scanner.nextLine();
                    System.out.print("Ingrese el género del nuevo libro: ");
                    String generoLibro = scanner.nextLine();
                    biblioteca.agregarLibro(new Libro(tituloLibro, autorLibro, generoLibro));
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();

                    Usuario usuario = null;
                    for (Usuario u : biblioteca.getListaUsuarios()) {
                        if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
                            usuario = u;
                        break;
                        }
                    }

                    if (usuario != null) {
                        System.out.print("Ingrese el título del libro a alquilar: ");
                        String tituloAlquilar = scanner.nextLine();
                        List<Libro> librosAlquilar = biblioteca.buscarLibroPorTitulo(tituloAlquilar);

                    if (!librosAlquilar.isEmpty()) {
                        biblioteca.alquilarLibro(usuario, librosAlquilar.get(0));
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    } else {
                    System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioDevolver = scanner.nextLine();
                    Usuario usuarioDevolver = new Usuario(nombreUsuarioDevolver, new ArrayList<>());
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    Libro libroDevolver = new Libro(tituloDevolver, "", "");
                    biblioteca.devolverLibro(usuarioDevolver, libroDevolver);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del nuevo usuario: ");
                    String nombreNuevoUsuario = scanner.nextLine();
                    biblioteca.registrarUsuario(new Usuario(nombreNuevoUsuario, new ArrayList<>()));
                    break;
                case 5:
                    System.out.println("Libros en la biblioteca:");
                    List<Libro> librosEnBiblioteca = biblioteca.getListaLibros();
                    for (Libro libroEnBiblioteca : librosEnBiblioteca) {
                        System.out.println("Título: " + libroEnBiblioteca.getTitulo());
                        System.out.println("Autor: " + libroEnBiblioteca.getAutor());
                        System.out.println("Género: " + libroEnBiblioteca.getGenero());
                        System.out.println();  
                    }
                    break;
                case 6:
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}

