package cl.praxis.EscuelaRural_JPA.controller;

import cl.praxis.EscuelaRural_JPA.model.Curso;
import cl.praxis.EscuelaRural_JPA.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.obtenerCursos();
        model.addAttribute("cursos", cursos);
        return "listar-cursos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "nuevo-curso";
    }

    @PostMapping
    public String guardarCurso(@ModelAttribute Curso curso) {
        cursoService.guardarCurso(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCurso(@PathVariable Long id, Model model) {
        Curso curso = cursoService.obtenerCursoPorId(id);
        if (curso != null) {
            model.addAttribute("curso", curso);
            return "editar-curso";
        } else {
            return "redirect:/cursos";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCurso(@PathVariable Long id, @ModelAttribute Curso curso) {
        curso.setId(id);
        cursoService.guardarCurso(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return "redirect:/cursos";
    }
}
