package com.sena.security.IRepository.Tienda;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Tienda.Factura;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface IFacturaRepositorio extends IBaseRepository<Factura, Long>{
    
}
