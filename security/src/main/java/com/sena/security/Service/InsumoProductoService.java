package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.InsumoProducto;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IInsumoProductoRepositorio;
import com.sena.security.IService.IInsumoProductoService;

@Service
public class InsumoProductoService extends ABaseService<InsumoProducto> implements  IInsumoProductoService {

    @Autowired
    private IInsumoProductoRepositorio repositorio;

    @Override
    protected IBaseRepository<InsumoProducto, Long> getRepository() {
        return repositorio;
    }
    
}
