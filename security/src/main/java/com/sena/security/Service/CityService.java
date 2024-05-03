package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.City;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.ICityRepository;
import com.sena.security.IService.ICityService;

@Service
public class CityService extends ABaseService<City> implements ICityService{
    @Autowired
    private ICityRepository repository;

    @Override
    protected IBaseRepository<City, Long> getRepository(){
        return repository;
    }
}
