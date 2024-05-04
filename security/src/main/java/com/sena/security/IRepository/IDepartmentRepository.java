package com.sena.security.IRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.security.DTO.ICountryDto;
import com.sena.security.Entity.Department;

@Repository
public interface IDepartmentRepository extends IBaseRepository<Department, Long>{
    
    @Query(value = "SELECT "
    + "name "
    + "FROM "
    + "country "
    + "WHERE "
    + "id = :id", nativeQuery = true)
    ICountryDto getName(@Param("id") Long id);
}
