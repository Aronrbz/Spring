package cl.praxis.EscuelaRural_JPA.controller;

import cl.praxis.EscuelaRural_JPA.model.Curso;
import cl.praxis.EscuelaRural_JPA.model.Estudiante;
import cl.praxis.EscuelaRural_JPA.service.CursoService;
import cl.praxis.EscuelaRural_JPA.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;
    private final CursoService cursoService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService, CursoService cursoService) {
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.obtenerTodosLosEstudiantes());
        return "lista_estudiantes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("cursos", cursoService.obtenerCursos());
        return "formulario_estudiante";
    }

    @PostMapping
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable("id") Long id, Model model) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("cursos", cursoService.obtenerCursos());
        return "formulario_estudiante";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable("id") Long id) {
        estudianteService.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
