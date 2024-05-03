package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.UnidadMedida;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IUnidadMedidaRepositorio;
import com.sena.security.IService.IUnidadMedidaService;

@Service
public class UnidadMedidaService extends ABaseService<UnidadMedida> implements  IUnidadMedidaService {

    @Autowired
    private IUnidadMedidaRepositorio repositorio;

    @Override
    protected IBaseRepository<UnidadMedida, Long> getRepository() {
        return repositorio;
    }
    
}
