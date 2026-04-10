package com.fullstack.certamen.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fullstack.certamen.model.Libro;

@Repository
public class LibroRepository {
    
    // ARREGLO que guarda todos los libros (es como la base de datos)
    private List<Libro> listaLibros = new ArrayList<>();

    // Metodo que retorna todos los libros
    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    // Metodo para buscar libro por su id(Si es int ==)
    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros){
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    // Metodo para buscar libro por su isbn (Si es String es .equals)
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros){
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // Metodo para guardar
    public Libro guardar(Libro lib) {
        listaLibros.add(lib);
        return lib;
    }

    //Metodo actualizar
    public Libro actualizar(Libro lib) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }

    // Metodo para eliminar
    public void eliminar(int id) {
        listaLibros.removeIf(x -> x.getId() == id);
    }
}


