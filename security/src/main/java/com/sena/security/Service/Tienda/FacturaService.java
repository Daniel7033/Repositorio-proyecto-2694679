package com.sena.security.Service.Tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Tienda.Factura;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Tienda.IFacturaRepositorio;
import com.sena.security.IService.Tienda.IFacturaService;
import com.sena.security.Service.ABaseService;

@Service
public class FacturaService extends ABaseService<Factura> implements  IFacturaService {

    @Autowired
    private IFacturaRepositorio repositorio;

    @Override
    protected IBaseRepository<Factura, Long> getRepository() {
        return repositorio;
    }
    
}
