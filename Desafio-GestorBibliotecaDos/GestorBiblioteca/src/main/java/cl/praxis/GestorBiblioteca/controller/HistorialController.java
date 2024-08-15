package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping("/historial")
    public String verHistorial(Model model) {
        model.addAttribute("historial", historialService.obtenerHistorial());
        return "historial";
    }
}
