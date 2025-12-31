package galacticos_app_back.galacticos.controller;

import galacticos_app_back.galacticos.entity.Estudiante;
import galacticos_app_back.galacticos.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;
    
    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodos() {
        return ResponseEntity.ok(estudianteService.obtenerTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Integer id) {
        Optional<Estudiante> estudiante = estudianteService.obtenerPorId(id);
        return estudiante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/activos/lista")
    public ResponseEntity<List<Estudiante>> obtenerActivos() {
        return ResponseEntity.ok(estudianteService.obtenerActivos());
    }
    
    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<List<Estudiante>> obtenerPorNivel(@PathVariable Estudiante.NivelActual nivel) {
        return ResponseEntity.ok(estudianteService.obtenerPorNivel(nivel));
    }
    
    @GetMapping("/sede/{idSede}")
    public ResponseEntity<List<Estudiante>> obtenerPorSede(@PathVariable Integer idSede) {
        return ResponseEntity.ok(estudianteService.obtenerPorSede(idSede));
    }
    
    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.crear(estudiante));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        Estudiante actualizado = estudianteService.actualizar(id, estudiante);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Estudiante> desactivar(@PathVariable Integer id) {
        Estudiante desactivado = estudianteService.desactivar(id);
        return desactivado != null ? ResponseEntity.ok(desactivado) : ResponseEntity.notFound().build();
    }
}
