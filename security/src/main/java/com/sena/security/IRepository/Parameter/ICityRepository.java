package com.sena.security.IRepository.Parameter;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Parameter.City;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface ICityRepository extends IBaseRepository<City, Long>{
    
}
