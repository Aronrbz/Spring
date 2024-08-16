package cl.praxis.ClinicaPostPandemia.service;

import cl.praxis.ClinicaPostPandemia.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private List<Paciente> pacientes = new ArrayList<>();
    private Long nextId = 1L;

    public List<Paciente> listarTodos() {
        return pacientes;
    }

    public Optional<Paciente> obtenerPorId(Long id) {
        return pacientes.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Paciente agregarPaciente(Paciente paciente) {
        paciente.setId(nextId++);
        pacientes.add(paciente);
        return paciente;
    }

    public Paciente actualizarPaciente(Long id, Paciente datosActualizados) {
        Optional<Paciente> pacienteOpt = obtenerPorId(id);
        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            paciente.setNombre(datosActualizados.getNombre());
            paciente.setEdad(datosActualizados.getEdad());
            return paciente;
        }
        return null;
    }

    public boolean eliminarPaciente(Long id) {
        return pacientes.removeIf(p -> p.getId().equals(id));
    }
}
