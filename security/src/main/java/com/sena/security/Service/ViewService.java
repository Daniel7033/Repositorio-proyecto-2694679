package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.View;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IViewRepository;
import com.sena.security.IService.IViewService;

@Service
public class ViewService extends ABaseService<View> implements IViewService{
    @Autowired
    private IViewRepository repository;

    @Override
    protected IBaseRepository<View, Long> getRepository(){
        return repository;
    }
}
