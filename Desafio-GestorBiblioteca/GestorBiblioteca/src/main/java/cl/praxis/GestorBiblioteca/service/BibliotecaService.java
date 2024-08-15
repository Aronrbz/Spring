package cl.praxis.GestorBiblioteca.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {

    private static final Logger logger = LoggerFactory.getLogger(BibliotecaService.class);

    public void registrarLibro(String titulo) {
        logger.info("Registrando el libro: " + titulo);
    }
}
