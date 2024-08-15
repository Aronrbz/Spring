package cl.praxis.GestorBiblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevolucionService {

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private HistorialService historialService;

    public boolean devolverLibro(String titulo) {
        if (prestamoService.estaPrestado(titulo)) {
            prestamoService.prestarLibro(titulo);
            historialService.registrarDevolucion(titulo);
            return true;
        }
        return false;
    }
}
