package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/catalogo")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("libros", libroService.obtenerTodosLosLibros());
        return "catalogo";
    }

    @PostMapping("/buscar")
    public String buscarLibro(@RequestParam("titulo") String titulo, Model model) {
        model.addAttribute("resultados", libroService.buscarPorTitulo(titulo));
        return "resultados";
    }

    @GetMapping("/agregarLibro")
    public String mostrarFormularioAgregarLibro() {
        return "agregarLibro";
    }

    @PostMapping("/agregarLibro")
    public String agregarLibro(@RequestParam("titulo") String titulo,
                               @RequestParam("autor") String autor) {
        libroService.agregarLibro(titulo, autor);
        return "redirect:/catalogo";
    }
}
