package com.sena.security.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.security.Entity.Department;

@Repository
public interface IDepartmentRepository extends IBaseRepository<Department, Long>{
    
}
