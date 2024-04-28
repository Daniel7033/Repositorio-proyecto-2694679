package com.sena.security.Service.Tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Tienda.Insumo;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Tienda.IInsumoRepositorio;
import com.sena.security.IService.Tienda.IInsumoService;
import com.sena.security.Service.ABaseService;

@Service
public class InsumoService extends ABaseService<Insumo> implements  IInsumoService {

    @Autowired
    private IInsumoRepositorio repositorio;

    @Override
    protected IBaseRepository<Insumo, Long> getRepository() {
        return repositorio;
    }
    
}
