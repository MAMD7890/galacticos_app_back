package galacticos_app_back.galacticos.service;

import galacticos_app_back.galacticos.entity.RecordatorioPago;
import galacticos_app_back.galacticos.repository.RecordatorioPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecordatorioPagoService {
    
    @Autowired
    private RecordatorioPagoRepository recordatorioPagoRepository;
    
    public List<RecordatorioPago> obtenerTodos() {
        return recordatorioPagoRepository.findAll();
    }
    
    public Optional<RecordatorioPago> obtenerPorId(Integer id) {
        return recordatorioPagoRepository.findById(id);
    }
    
    public RecordatorioPago crear(RecordatorioPago recordatorio) {
        return recordatorioPagoRepository.save(recordatorio);
    }
    
    public RecordatorioPago actualizar(Integer id, RecordatorioPago recordatorio) {
        Optional<RecordatorioPago> existente = recordatorioPagoRepository.findById(id);
        if (existente.isPresent()) {
            recordatorio.setIdRecordatorio(id);
            return recordatorioPagoRepository.save(recordatorio);
        }
        return null;
    }
    
    public void eliminar(Integer id) {
        recordatorioPagoRepository.deleteById(id);
    }
}
