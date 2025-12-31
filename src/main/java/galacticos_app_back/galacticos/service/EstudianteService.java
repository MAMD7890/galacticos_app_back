package galacticos_app_back.galacticos.service;

import galacticos_app_back.galacticos.entity.Estudiante;
import galacticos_app_back.galacticos.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    
    @Autowired
    private EstudianteRepository estudianteRepository;
    
    // Obtener todos los estudiantes
    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }
    
    // Obtener estudiante por ID
    public Optional<Estudiante> obtenerPorId(Integer id) {
        return estudianteRepository.findById(id);
    }
    
    // Obtener estudiantes activos
    public List<Estudiante> obtenerActivos() {
        return estudianteRepository.findByEstado(true);
    }
    
    // Obtener estudiantes por nivel
    public List<Estudiante> obtenerPorNivel(Estudiante.NivelActual nivel) {
        return estudianteRepository.findByNivelActual(nivel);
    }
    
    // Obtener estudiantes por sede
    public List<Estudiante> obtenerPorSede(Integer idSede) {
        return estudianteRepository.findBySedeIdSede(idSede);
    }
    
    // Crear nuevo estudiante
    public Estudiante crear(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
    
    // Actualizar estudiante
    public Estudiante actualizar(Integer id, Estudiante estudiante) {
        Optional<Estudiante> existente = estudianteRepository.findById(id);
        if (existente.isPresent()) {
            estudiante.setIdEstudiante(id);
            return estudianteRepository.save(estudiante);
        }
        return null;
    }
    
    // Eliminar estudiante
    public void eliminar(Integer id) {
        estudianteRepository.deleteById(id);
    }
    
    // Desactivar estudiante
    public Estudiante desactivar(Integer id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        if (estudiante.isPresent()) {
            estudiante.get().setEstado(false);
            return estudianteRepository.save(estudiante.get());
        }
        return null;
    }
}
