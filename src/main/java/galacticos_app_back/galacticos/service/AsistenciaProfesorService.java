package galacticos_app_back.galacticos.service;

import galacticos_app_back.galacticos.entity.AsistenciaProfesor;
import galacticos_app_back.galacticos.repository.AsistenciaProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaProfesorService {
    
    @Autowired
    private AsistenciaProfesorRepository asistenciaProfesorRepository;
    
    public List<AsistenciaProfesor> obtenerTodos() {
        return asistenciaProfesorRepository.findAll();
    }
    
    public Optional<AsistenciaProfesor> obtenerPorId(Integer id) {
        return asistenciaProfesorRepository.findById(id);
    }
    
    public AsistenciaProfesor crear(AsistenciaProfesor asistencia) {
        return asistenciaProfesorRepository.save(asistencia);
    }
    
    public AsistenciaProfesor actualizar(Integer id, AsistenciaProfesor asistencia) {
        Optional<AsistenciaProfesor> existente = asistenciaProfesorRepository.findById(id);
        if (existente.isPresent()) {
            asistencia.setIdAsistenciaProfesor(id);
            return asistenciaProfesorRepository.save(asistencia);
        }
        return null;
    }
    
    public void eliminar(Integer id) {
        asistenciaProfesorRepository.deleteById(id);
    }
}
