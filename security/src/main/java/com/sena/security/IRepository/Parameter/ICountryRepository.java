package com.sena.security.IRepository.Parameter;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Parameter.Country;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface ICountryRepository extends IBaseRepository<Country, Long>{
    
}
