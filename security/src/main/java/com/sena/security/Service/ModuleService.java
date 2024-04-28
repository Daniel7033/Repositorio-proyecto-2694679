package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IModuleRepository;
import com.sena.security.IService.IModuleService;
import com.sena.security.Entity.Module;

@Service
public class ModuleService extends ABaseService<Module> implements IModuleService{
    @Autowired
    private IModuleRepository repository;

    @Override
    protected IBaseRepository<Module, Long> getRepository(){
        return repository;
    }
}
