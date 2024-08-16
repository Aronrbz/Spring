package cl.praxis.ClinicaPostPandemia.controller;

import cl.praxis.ClinicaPostPandemia.model.Paciente;
import cl.praxis.ClinicaPostPandemia.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "pacientes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "formularioPaciente";
    }

    @PostMapping
    public String agregarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.agregarPaciente(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.obtenerPorId(id).orElse(null);
        model.addAttribute("paciente", paciente);
        return "formularioPaciente";
    }

    @PostMapping("/editar/{id}")
    public String actualizarPaciente(@PathVariable Long id, @ModelAttribute Paciente paciente) {
        pacienteService.actualizarPaciente(id, paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return "redirect:/pacientes";
    }
}
