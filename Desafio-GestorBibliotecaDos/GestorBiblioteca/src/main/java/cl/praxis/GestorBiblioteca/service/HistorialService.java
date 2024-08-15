package cl.praxis.GestorBiblioteca.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialService {

    private List<String> historial = new ArrayList<>();

    public void registrarPrestamo(String titulo) {
        historial.add("Préstamo: " + titulo);
    }

    public void registrarDevolucion(String titulo) {
        historial.add("Devolución: " + titulo);
    }

    public List<String> obtenerHistorial() {
        return historial;
    }
}
