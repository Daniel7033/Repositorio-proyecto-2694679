package com.sena.security.IRepository.Tienda;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Tienda.InsumoProducto;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface IInsumoProductoRepositorio extends IBaseRepository<InsumoProducto, Long>{
    
}
