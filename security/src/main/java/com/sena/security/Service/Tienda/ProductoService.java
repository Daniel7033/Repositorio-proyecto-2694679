package com.sena.security.Service.Tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Tienda.Producto;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Tienda.IProductoRepositorio;
import com.sena.security.IService.Tienda.IProductoService;
import com.sena.security.Service.ABaseService;

@Service
public class ProductoService extends ABaseService<Producto> implements  IProductoService {

    @Autowired
    private IProductoRepositorio repositorio;

    @Override
    protected IBaseRepository<Producto, Long> getRepository() {
        return repositorio;
    }
    
}
