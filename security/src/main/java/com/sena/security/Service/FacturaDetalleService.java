package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.FacturaDetalle;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IFacturaDetalleRepositorio;
import com.sena.security.IService.IFacturaDetalleService;

@Service
public class FacturaDetalleService extends ABaseService<FacturaDetalle> implements  IFacturaDetalleService {

    @Autowired
    private IFacturaDetalleRepositorio repositorio;

    @Override
    protected IBaseRepository<FacturaDetalle, Long> getRepository() {
        return repositorio;
    }
    
}
