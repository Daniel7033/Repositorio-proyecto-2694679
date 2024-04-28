package com.sena.security.Service.Tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Tienda.UnidadMedida;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Tienda.IUnidadMedidaRepositorio;
import com.sena.security.IService.Tienda.IUnidadMedidaService;
import com.sena.security.Service.ABaseService;

@Service
public class UnidadMedidaService extends ABaseService<UnidadMedida> implements  IUnidadMedidaService {

    @Autowired
    private IUnidadMedidaRepositorio repositorio;

    @Override
    protected IBaseRepository<UnidadMedida, Long> getRepository() {
        return repositorio;
    }
    
}
