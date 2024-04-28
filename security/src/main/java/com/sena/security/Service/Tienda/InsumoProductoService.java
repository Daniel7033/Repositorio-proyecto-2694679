package com.sena.security.Service.Tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Tienda.InsumoProducto;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Tienda.IInsumoProductoRepositorio;
import com.sena.security.IService.Tienda.IInsumoProductoService;
import com.sena.security.Service.ABaseService;

@Service
public class InsumoProductoService extends ABaseService<InsumoProducto> implements  IInsumoProductoService {

    @Autowired
    private IInsumoProductoRepositorio repositorio;

    @Override
    protected IBaseRepository<InsumoProducto, Long> getRepository() {
        return repositorio;
    }
    
}
