package com.sena.security.IRepository.Parameter;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Parameter.Department;
import com.sena.security.IRepository.IBaseRepository;

@Repository
public interface IDepartmentRepository extends IBaseRepository<Department, Long>{
    
}
