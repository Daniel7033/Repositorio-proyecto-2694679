package com.sena.security.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Person;

@Repository
public interface IPersonRepository extends IBaseRepository <Person, Long>{
    /* 
     * ...
     */
}
