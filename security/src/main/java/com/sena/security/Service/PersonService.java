package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Person;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IPersonRepository;
import com.sena.security.IService.IPersonService;

@Service
public class PersonService extends ABaseService<Person> implements IPersonService{

    @Autowired
    private IPersonRepository repository;    

    @Override
    protected IBaseRepository<Person, Long> getRepository(){
        return repository;
    }

}
