package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/prestar")
    public String solicitarPrestamo(@RequestParam("titulo") String titulo, Model model) {
        boolean exito = prestamoService.prestarLibro(titulo);
        model.addAttribute("mensaje", exito ? "Préstamo exitoso" : "Libro no disponible");
        return "resultadoPrestamo";
    }
}
