package com.sena.security.Service.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Parameter.City;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Parameter.ICityRepository;
import com.sena.security.IService.Parameter.ICityService;
import com.sena.security.Service.ABaseService;

@Service
public class CityService extends ABaseService<City> implements ICityService{
    @Autowired
    private ICityRepository repository;

    @Override
    protected IBaseRepository<City, Long> getRepository(){
        return repository;
    }
}
