package com.sena.security.IRepository.Tienda;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Tienda.Producto;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface IProductoRepositorio extends IBaseRepository<Producto, Long>{
    
}
