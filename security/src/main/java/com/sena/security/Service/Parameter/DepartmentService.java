package com.sena.security.Service.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Parameter.Department;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.Parameter.IDepartmentRepository;
import com.sena.security.IService.Parameter.IDepartmentService;
import com.sena.security.Service.ABaseService;

@Service
public class DepartmentService extends ABaseService<Department> implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Override
    protected IBaseRepository<Department, Long> getRepository(){
        return repository;
    }
}
