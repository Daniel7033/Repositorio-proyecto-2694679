package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Inventario;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IInventarioRepositorio;
import com.sena.security.IService.IInventarioService;

@Service
public class InventarioService extends ABaseService<Inventario> implements  IInventarioService {

    @Autowired
    private IInventarioRepositorio repositorio;

    @Override
    protected IBaseRepository<Inventario, Long> getRepository() {
        return repositorio;
    }
    
}
