package galacticos_app_back.galacticos.controller;

import galacticos_app_back.galacticos.entity.AsistenciaEstudiante;
import galacticos_app_back.galacticos.service.AsistenciaEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asistencia-estudiante")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AsistenciaEstudianteController {
    
    @Autowired
    private AsistenciaEstudianteService asistenciaEstudianteService;
    
    @GetMapping
    public ResponseEntity<List<AsistenciaEstudiante>> obtenerTodos() {
        return ResponseEntity.ok(asistenciaEstudianteService.obtenerTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaEstudiante> obtenerPorId(@PathVariable Integer id) {
        Optional<AsistenciaEstudiante> asistencia = asistenciaEstudianteService.obtenerPorId(id);
        return asistencia.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<AsistenciaEstudiante> crear(@RequestBody AsistenciaEstudiante asistencia) {
        return ResponseEntity.ok(asistenciaEstudianteService.crear(asistencia));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaEstudiante> actualizar(@PathVariable Integer id, @RequestBody AsistenciaEstudiante asistencia) {
        AsistenciaEstudiante actualizado = asistenciaEstudianteService.actualizar(id, asistencia);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        asistenciaEstudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
