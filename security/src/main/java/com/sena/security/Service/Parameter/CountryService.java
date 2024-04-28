package com.sena.security.Service.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Parameter.Country;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Parameter.ICountryRepository;
import com.sena.security.IService.Parameter.ICountryService;
import com.sena.security.Service.ABaseService;

@Service
public class CountryService extends ABaseService<Country> implements ICountryService{
    @Autowired
    private ICountryRepository repository;

    @Override
    protected IBaseRepository<Country, Long> getRepository(){
        return repository;
    }
}
