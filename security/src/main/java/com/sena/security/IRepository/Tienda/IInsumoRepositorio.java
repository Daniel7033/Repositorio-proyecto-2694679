package com.sena.security.IRepository.Tienda;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Tienda.Insumo;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface IInsumoRepositorio extends IBaseRepository<Insumo, Long>{
    
}
