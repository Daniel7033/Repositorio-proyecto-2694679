package com.sena.security.Service.Tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Tienda.InventarioDetalle;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Tienda.IInventarioDetalleRepositorio;
import com.sena.security.IService.Tienda.IInventarioDetalleService;
import com.sena.security.Service.ABaseService;

@Service
public class InventarioDetalleService extends ABaseService<InventarioDetalle> implements  IInventarioDetalleService {

    @Autowired
    private IInventarioDetalleRepositorio repositorio;

    @Override
    protected IBaseRepository<InventarioDetalle, Long> getRepository() {
        return repositorio;
    }
    
}
