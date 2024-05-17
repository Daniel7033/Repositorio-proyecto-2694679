package com.sena.security.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.security.DTO.ICountryDto;
import com.sena.security.Entity.Country;

@Repository
public interface ICountryRepository extends IBaseRepository<Country, Long>{
    
    // Consulta SQL para filtrar datos
    @Query(value = "SELECT "
    + "code, "
    + "name, "
    + "state "
    + "FROM "
    + "country "
    + "WHERE "
    + "(code IS NULL OR code LIKE CONCAT('%', :code, '%')) "
    + "OR (name IS NULL OR name LIKE CONCAT('%', :name, '%')) ", nativeQuery = true)
    List<ICountryDto> getFiltrar(@Param("code") String code, @Param("name") String name);
    
    // Consulta SQL para filtrar datos por estado(state)
    @Query(value = "SELECT "
                + "code, "
                + "name, "
                + "state "
                + "FROM "
                + "country "
                + "WHERE state = :state ", nativeQuery = true)
    List<ICountryDto> getFiltrarEstado(@Param("state") Boolean state);

    
}
