package com.sena.security.IRepository.Tienda;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Tienda.Inventario;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface IInventarioRepositorio extends IBaseRepository<Inventario, Long>{
    
}
