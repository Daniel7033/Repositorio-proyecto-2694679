package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.User;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IUserRepository;
import com.sena.security.IService.IUserService;

@Service
public class UserService extends ABaseService<User> implements IUserService{
    @Autowired
    private IUserRepository repository;

    @Override
    protected IBaseRepository<User, Long> getRepository(){
        return repository;
    }
}
