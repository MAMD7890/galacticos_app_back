package galacticos_app_back.galacticos.service;

import galacticos_app_back.galacticos.entity.Gasto;
import galacticos_app_back.galacticos.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GastoService {
    
    @Autowired
    private GastoRepository gastoRepository;
    
    public List<Gasto> obtenerTodos() {
        return gastoRepository.findAll();
    }
    
    public Optional<Gasto> obtenerPorId(Integer id) {
        return gastoRepository.findById(id);
    }
    
    public Gasto crear(Gasto gasto) {
        return gastoRepository.save(gasto);
    }
    
    public Gasto actualizar(Integer id, Gasto gasto) {
        Optional<Gasto> existente = gastoRepository.findById(id);
        if (existente.isPresent()) {
            gasto.setIdGasto(id);
            return gastoRepository.save(gasto);
        }
        return null;
    }
    
    public void eliminar(Integer id) {
        gastoRepository.deleteById(id);
    }
}
