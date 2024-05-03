package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Producto;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IProductoRepositorio;
import com.sena.security.IService.IProductoService;

@Service
public class ProductoService extends ABaseService<Producto> implements  IProductoService {

    @Autowired
    private IProductoRepositorio repositorio;

    @Override
    protected IBaseRepository<Producto, Long> getRepository() {
        return repositorio;
    }
    
}
