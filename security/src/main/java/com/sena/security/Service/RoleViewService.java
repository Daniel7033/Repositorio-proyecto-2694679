package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.RoleView;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IRoleViewRepository;
import com.sena.security.IService.IRoleViewService;

@Service
public class RoleViewService extends ABaseService<RoleView> implements IRoleViewService{
    @Autowired
    private IRoleViewRepository repository;

    @Override
    protected IBaseRepository<RoleView, Long> getRepository() {
        return repository;
    }
    
}
