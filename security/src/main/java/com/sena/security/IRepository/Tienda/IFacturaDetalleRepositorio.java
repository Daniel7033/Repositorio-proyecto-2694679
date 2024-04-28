package com.sena.security.IRepository.Tienda;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Tienda.FacturaDetalle;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface IFacturaDetalleRepositorio extends IBaseRepository<FacturaDetalle, Long>{
    
}
