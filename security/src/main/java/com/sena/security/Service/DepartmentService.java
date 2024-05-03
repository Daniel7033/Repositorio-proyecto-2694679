package com.sena.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Department;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IDepartmentRepository;
import com.sena.security.IService.IDepartmentService;

@Service
public class DepartmentService extends ABaseService<Department> implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Override
    protected IBaseRepository<Department, Long> getRepository(){
        return repository;
    }
}
