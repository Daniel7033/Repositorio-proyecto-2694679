package com.sena.security.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.User;

@Repository
public interface IUserRepository extends IBaseRepository<User, Long>{
    
}
