package com.sena.security.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Country;

@Repository
public interface ICountryRepository extends IBaseRepository<Country, Long>{
    
}
