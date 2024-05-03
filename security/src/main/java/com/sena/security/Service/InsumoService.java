package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Insumo;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IInsumoRepositorio;
import com.sena.security.IService.IInsumoService;

@Service
public class InsumoService extends ABaseService<Insumo> implements  IInsumoService {

    @Autowired
    private IInsumoRepositorio repositorio;

    @Override
    protected IBaseRepository<Insumo, Long> getRepository() {
        return repositorio;
    }
    
}
