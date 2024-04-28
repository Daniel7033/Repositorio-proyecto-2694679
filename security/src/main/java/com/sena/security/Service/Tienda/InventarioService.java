package com.sena.security.Service.Tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Tienda.Inventario;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Tienda.IInventarioRepositorio;
import com.sena.security.IService.Tienda.IInventarioService;
import com.sena.security.Service.ABaseService;

@Service
public class InventarioService extends ABaseService<Inventario> implements  IInventarioService {

    @Autowired
    private IInventarioRepositorio repositorio;

    @Override
    protected IBaseRepository<Inventario, Long> getRepository() {
        return repositorio;
    }
    
}
