package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.InventarioDetalle;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IInventarioDetalleRepositorio;
import com.sena.security.IService.IInventarioDetalleService;

@Service
public class InventarioDetalleService extends ABaseService<InventarioDetalle> implements  IInventarioDetalleService {

    @Autowired
    private IInventarioDetalleRepositorio repositorio;

    @Override
    protected IBaseRepository<InventarioDetalle, Long> getRepository() {
        return repositorio;
    }
    
}
