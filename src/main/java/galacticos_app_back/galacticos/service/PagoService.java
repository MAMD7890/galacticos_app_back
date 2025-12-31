package galacticos_app_back.galacticos.service;

import galacticos_app_back.galacticos.entity.Pago;
import galacticos_app_back.galacticos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    
    @Autowired
    private PagoRepository pagoRepository;
    
    // Obtener todos los pagos
    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }
    
    // Obtener pago por ID
    public Optional<Pago> obtenerPorId(Integer id) {
        return pagoRepository.findById(id);
    }
    
    // Obtener pagos de un estudiante
    public List<Pago> obtenerPorEstudiante(Integer idEstudiante) {
        return pagoRepository.findByEstudianteIdEstudiante(idEstudiante);
    }
    
    // Obtener pagos pendientes
    public List<Pago> obtenerPendientes() {
        return pagoRepository.findByEstadoPago(Pago.EstadoPago.PENDIENTE);
    }
    
    // Obtener pagos pagados
    public List<Pago> obtenerPagados() {
        return pagoRepository.findByEstadoPago(Pago.EstadoPago.PAGADO);
    }
    
    // Obtener pagos vencidos
    public List<Pago> obtenerVencidos() {
        return pagoRepository.findByEstadoPago(Pago.EstadoPago.VENCIDO);
    }
    
    // Registrar pago
    public Pago registrarPago(Pago pago) {
        pago.setEstadoPago(Pago.EstadoPago.PAGADO);
        return pagoRepository.save(pago);
    }
    
    // Actualizar pago completo
    public Pago actualizar(Integer id, Pago pago) {
        Optional<Pago> existente = pagoRepository.findById(id);
        if (existente.isPresent()) {
            pago.setIdPago(id);
            return pagoRepository.save(pago);
        }
        return null;
    }
    
    // Actualizar estado de pago
    public Pago actualizarEstado(Integer idPago, Pago.EstadoPago nuevoEstado) {
        Optional<Pago> pago = pagoRepository.findById(idPago);
        if (pago.isPresent()) {
            pago.get().setEstadoPago(nuevoEstado);
            return pagoRepository.save(pago.get());
        }
        return null;
    }
    
    // Eliminar pago
    public void eliminar(Integer idPago) {
        pagoRepository.deleteById(idPago);
    }
}