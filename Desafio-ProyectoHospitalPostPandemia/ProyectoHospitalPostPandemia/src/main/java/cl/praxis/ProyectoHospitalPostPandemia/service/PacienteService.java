package cl.praxis.ProyectoHospitalPostPandemia.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class PacienteService {

    public List<String> obtenerPacientes() {
        return Arrays.asList("Aron Bustos", "Gaspar Bustos", "Ignacia Lopez");
    }
}
