
package main;

import java.util.ArrayList;
import java.util.List;


public class Biblioteca {
    private List<Libro> listaLibros;
    private List<Usuario> listaUsuarios;

    public Biblioteca(List<Libro> listaLibros, List<Usuario> listaUsuarios) {
        this.listaLibros = listaLibros;
        this.listaUsuarios = listaUsuarios;
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    // metodos
    
    public void agregarLibro(Libro libro) {
        try {
            listaLibros.add(libro);
            System.out.println("Libro agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar libro: " + e.getMessage());
        }
    }
    
      public void eliminarLibro(Libro libro) {
        try {
            listaLibros.remove(libro);
            System.out.println("Libro eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar libro: " + e.getMessage());
        }
    }
      
    public void registrarUsuario(Usuario usuario) {
        if (!listaUsuarios.contains(usuario)) {
            listaUsuarios.add(usuario);
            System.out.println("El usuario fue registrado de forma exitosa");
        } else {
            System.out.println("Error: El usuario ya se encuentra registrado");
        }
    }

    public void alquilarLibro(Usuario usuario, Libro libro) {
        try {
            if (listaUsuarios.contains(usuario) && listaLibros.contains(libro)) {
                usuario.alquilarLibro(libro);
                listaLibros.remove(libro);
                System.out.println(usuario.getNombre() + " ha alquilado el libro: " + libro.getTitulo());
            } else {
                System.out.println("Error: Usuario o libro no encontrados");
            }
        } catch (Exception e) {
            System.out.println("Error al alquilar libro: " + e.getMessage());
        }
    }

    public void devolverLibro(Usuario usuario, Libro libro) {
    try {
        if (listaUsuarios.contains(usuario) && usuario.getLibrosAlquilados().contains(libro)) {
            usuario.devolverLibro(libro);
            listaLibros.add(libro);
            System.out.println(usuario.getNombre() + " ha devuelto el libro: " + libro.getTitulo());
        } else {
            System.out.println("Error: Usuario o libro no encontrados");
        }
    } catch (Exception e) {
        System.out.println("Error al devolver libro: " + e.getMessage());
    }
}
    
    public List<Libro> buscarLibroPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> buscarLibroPorAutor(String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> buscarLibroPorGenero(String genero) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }
    
 
}
