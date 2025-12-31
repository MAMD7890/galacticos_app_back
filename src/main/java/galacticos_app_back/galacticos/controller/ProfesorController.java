package galacticos_app_back.galacticos.controller;

import galacticos_app_back.galacticos.entity.Profesor;
import galacticos_app_back.galacticos.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProfesorController {
    
    @Autowired
    private ProfesorService profesorService;
    
    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodos() {
        return ResponseEntity.ok(profesorService.obtenerTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable Integer id) {
        Optional<Profesor> profesor = profesorService.obtenerPorId(id);
        return profesor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/activos/lista")
    public ResponseEntity<List<Profesor>> obtenerActivos() {
        return ResponseEntity.ok(profesorService.obtenerActivos());
    }
    
    @PostMapping
    public ResponseEntity<Profesor> crear(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.crear(profesor));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Integer id, @RequestBody Profesor profesor) {
        Profesor actualizado = profesorService.actualizar(id, profesor);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Profesor> desactivar(@PathVariable Integer id) {
        Profesor desactivado = profesorService.desactivar(id);
        return desactivado != null ? ResponseEntity.ok(desactivado) : ResponseEntity.notFound().build();
    }
}
