package galacticos_app_back.galacticos.service;

import galacticos_app_back.galacticos.entity.AsistenciaEstudiante;
import galacticos_app_back.galacticos.repository.AsistenciaEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaEstudianteService {
    
    @Autowired
    private AsistenciaEstudianteRepository asistenciaEstudianteRepository;
    
    public List<AsistenciaEstudiante> obtenerTodos() {
        return asistenciaEstudianteRepository.findAll();
    }
    
    public Optional<AsistenciaEstudiante> obtenerPorId(Integer id) {
        return asistenciaEstudianteRepository.findById(id);
    }
    
    public AsistenciaEstudiante crear(AsistenciaEstudiante asistencia) {
        return asistenciaEstudianteRepository.save(asistencia);
    }
    
    public AsistenciaEstudiante actualizar(Integer id, AsistenciaEstudiante asistencia) {
        Optional<AsistenciaEstudiante> existente = asistenciaEstudianteRepository.findById(id);
        if (existente.isPresent()) {
            asistencia.setIdAsistencia(id);
            return asistenciaEstudianteRepository.save(asistencia);
        }
        return null;
    }
    
    public void eliminar(Integer id) {
        asistenciaEstudianteRepository.deleteById(id);
    }
}
