
package main;

import java.util.List;


public class Usuario {
    private String nombre;
    private List<Libro> librosAlquilados;

    public Usuario(String nombre, List<Libro> librosAlquilados) {
        this.nombre = nombre;
        this.librosAlquilados = librosAlquilados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibrosAlquilados() {
        return librosAlquilados;
    }

    public void setLibrosAlquilados(List<Libro> librosAlquilados) {
        this.librosAlquilados = librosAlquilados;
    }
    
    // metodos
    
    public void alquilarLibro(Libro libro) {
        librosAlquilados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        if (librosAlquilados.contains(libro)) {
            librosAlquilados.remove(libro);
            System.out.println(nombre + " devolvió el libro: " + libro.getTitulo());
        } else {
            System.out.println(nombre + " no tiene el libro: " + libro.getTitulo() + " alquilado.");
        }
    }
    
    
}
