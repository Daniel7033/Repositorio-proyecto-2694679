package com.sena.security.IRepository.Tienda;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Tienda.InventarioDetalle;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface IInventarioDetalleRepositorio extends IBaseRepository<InventarioDetalle, Long>{
    
}
