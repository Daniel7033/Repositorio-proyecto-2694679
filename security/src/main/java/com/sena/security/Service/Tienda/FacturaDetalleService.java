package com.sena.security.Service.Tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Tienda.FacturaDetalle;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Tienda.IFacturaDetalleRepositorio;
import com.sena.security.IService.Tienda.IFacturaDetalleService;
import com.sena.security.Service.ABaseService;

@Service
public class FacturaDetalleService extends ABaseService<FacturaDetalle> implements  IFacturaDetalleService {

    @Autowired
    private IFacturaDetalleRepositorio repositorio;

    @Override
    protected IBaseRepository<FacturaDetalle, Long> getRepository() {
        return repositorio;
    }
    
}
