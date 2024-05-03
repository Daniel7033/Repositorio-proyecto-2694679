package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Country;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.ICountryRepository;
import com.sena.security.IService.ICountryService;

@Service
public class CountryService extends ABaseService<Country> implements ICountryService{
    @Autowired
    private ICountryRepository repository;

    @Override
    protected IBaseRepository<Country, Long> getRepository(){
        return repository;
    }
}
