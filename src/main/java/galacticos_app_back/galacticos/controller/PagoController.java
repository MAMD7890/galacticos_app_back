package galacticos_app_back.galacticos.controller;

import galacticos_app_back.galacticos.entity.Pago;
import galacticos_app_back.galacticos.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PagoController {
    
    @Autowired
    private PagoService pagoService;
    
    @GetMapping
    public ResponseEntity<List<Pago>> obtenerTodos() {
        return ResponseEntity.ok(pagoService.obtenerTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPorId(@PathVariable Integer id) {
        Optional<Pago> pago = pagoService.obtenerPorId(id);
        return pago.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/estudiante/{idEstudiante}")
    public ResponseEntity<List<Pago>> obtenerPorEstudiante(@PathVariable Integer idEstudiante) {
        return ResponseEntity.ok(pagoService.obtenerPorEstudiante(idEstudiante));
    }
    
    @GetMapping("/pendientes/lista")
    public ResponseEntity<List<Pago>> obtenerPendientes() {
        return ResponseEntity.ok(pagoService.obtenerPendientes());
    }
    
    @GetMapping("/pagados/lista")
    public ResponseEntity<List<Pago>> obtenerPagados() {
        return ResponseEntity.ok(pagoService.obtenerPagados());
    }
    
    @GetMapping("/vencidos/lista")
    public ResponseEntity<List<Pago>> obtenerVencidos() {
        return ResponseEntity.ok(pagoService.obtenerVencidos());
    }
    
    @PostMapping
    public ResponseEntity<Pago> crear(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.registrarPago(pago));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Integer id, @RequestBody Pago pago) {
        Pago actualizado = pagoService.actualizar(id, pago);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    
    @PatchMapping("/{id}/estado/{estado}")
    public ResponseEntity<Pago> actualizarEstado(@PathVariable Integer id, @PathVariable Pago.EstadoPago estado) {
        Pago actualizado = pagoService.actualizarEstado(id, estado);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
