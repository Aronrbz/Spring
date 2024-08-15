package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    @PostMapping("/devolver")
    public String registrarDevolucion(@RequestParam("titulo") String titulo, Model model) {
        boolean exito = devolucionService.devolverLibro(titulo);
        model.addAttribute("mensaje", exito ? "Devolución exitosa" : "Libro no encontrado en préstamos");
        return "resultadoDevolucion";
    }
}
