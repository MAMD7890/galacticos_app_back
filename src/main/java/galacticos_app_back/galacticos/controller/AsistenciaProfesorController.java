package galacticos_app_back.galacticos.controller;

import galacticos_app_back.galacticos.entity.AsistenciaProfesor;
import galacticos_app_back.galacticos.service.AsistenciaProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asistencia-profesor")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AsistenciaProfesorController {
    
    @Autowired
    private AsistenciaProfesorService asistenciaProfesorService;
    
    @GetMapping
    public ResponseEntity<List<AsistenciaProfesor>> obtenerTodos() {
        return ResponseEntity.ok(asistenciaProfesorService.obtenerTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaProfesor> obtenerPorId(@PathVariable Integer id) {
        Optional<AsistenciaProfesor> asistencia = asistenciaProfesorService.obtenerPorId(id);
        return asistencia.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<AsistenciaProfesor> crear(@RequestBody AsistenciaProfesor asistencia) {
        return ResponseEntity.ok(asistenciaProfesorService.crear(asistencia));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaProfesor> actualizar(@PathVariable Integer id, @RequestBody AsistenciaProfesor asistencia) {
        AsistenciaProfesor actualizado = asistenciaProfesorService.actualizar(id, asistencia);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        asistenciaProfesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
