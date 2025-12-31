package galacticos_app_back.galacticos.service;

import galacticos_app_back.galacticos.entity.Profesor;
import galacticos_app_back.galacticos.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    
    @Autowired
    private ProfesorRepository profesorRepository;
    
    public List<Profesor> obtenerTodos() {
        return profesorRepository.findAll();
    }
    
    public Optional<Profesor> obtenerPorId(Integer id) {
        return profesorRepository.findById(id);
    }
    
    public List<Profesor> obtenerActivos() {
        return profesorRepository.findByEstado(true);
    }
    
    public Profesor crear(Profesor profesor) {
        return profesorRepository.save(profesor);
    }
    
    public Profesor actualizar(Integer id, Profesor profesor) {
        Optional<Profesor> existente = profesorRepository.findById(id);
        if (existente.isPresent()) {
            profesor.setIdProfesor(id);
            return profesorRepository.save(profesor);
        }
        return null;
    }
    
    public void eliminar(Integer id) {
        profesorRepository.deleteById(id);
    }
    
    public Profesor desactivar(Integer id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        if (profesor.isPresent()) {
            profesor.get().setEstado(false);
            return profesorRepository.save(profesor.get());
        }
        return null;
    }
}
