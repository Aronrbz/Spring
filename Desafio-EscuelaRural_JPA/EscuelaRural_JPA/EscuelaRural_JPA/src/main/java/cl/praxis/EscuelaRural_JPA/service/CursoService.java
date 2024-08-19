package cl.praxis.EscuelaRural_JPA.service;

import cl.praxis.EscuelaRural_JPA.model.Curso;
import cl.praxis.EscuelaRural_JPA.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional(readOnly = true)
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Curso obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
