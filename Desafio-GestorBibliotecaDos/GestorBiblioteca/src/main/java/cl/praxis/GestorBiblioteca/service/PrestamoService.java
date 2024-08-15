package cl.praxis.GestorBiblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PrestamoService {

    private Set<String> librosPrestados = new HashSet<>();

    @Autowired
    private HistorialService historialService;

    public boolean prestarLibro(String titulo) {
        if (librosPrestados.contains(titulo)) {
            return false;
        }
        librosPrestados.add(titulo);
        historialService.registrarPrestamo(titulo);
        return true;
    }

    public boolean estaPrestado(String titulo) {
        return librosPrestados.contains(titulo);
    }
}
