package cl.praxis.EscuelaRural_JPA.service;

import cl.praxis.EscuelaRural_JPA.model.Estudiante;
import cl.praxis.EscuelaRural_JPA.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Transactional(readOnly = true)
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Transactional
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Transactional
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }
}
