package cl.praxis.GestorBiblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private List<Libro> catalogo = new ArrayList<>();

    @Autowired
    private BibliotecaService bibliotecaService;

    public void agregarLibro(String titulo, String autor) {
        catalogo.add(new Libro(titulo, autor));
        bibliotecaService.registrarLibro(titulo); //acá uso BibliotecaService del desafio anterior para registrar la acción
    }

    public List<Libro> obtenerTodosLosLibros() {
        return catalogo;
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        return catalogo.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());
    }

    public static class Libro {
        private String titulo;
        private String autor;

        public Libro(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }
    }
}
