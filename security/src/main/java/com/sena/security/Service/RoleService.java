package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Role;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IRoleRepository;
import com.sena.security.IService.IRoleService;
@Service
public class RoleService extends ABaseService<Role> implements IRoleService{
    @Autowired
    private IRoleRepository repository;

    @Override
    protected IBaseRepository <Role, Long> getRepository() {
        return repository;
    }
}
