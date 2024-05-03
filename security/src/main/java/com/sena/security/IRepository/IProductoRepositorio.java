package com.sena.security.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Producto;

@Repository
public interface IProductoRepositorio extends IBaseRepository<Producto, Long>{
    
}
