package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Factura;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IFacturaRepositorio;
import com.sena.security.IService.IFacturaService;

@Service
public class FacturaService extends ABaseService<Factura> implements  IFacturaService {

    @Autowired
    private IFacturaRepositorio repositorio;

    @Override
    protected IBaseRepository<Factura, Long> getRepository() {
        return repositorio;
    }
    
}
