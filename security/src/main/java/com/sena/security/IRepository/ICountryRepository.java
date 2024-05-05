package com.sena.security.IRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.security.DTO.ICountryDto;
import com.sena.security.Entity.Country;

@Repository
public interface ICountryRepository extends IBaseRepository<Country, Long>{
    
    // @Query(value = "SELECT "
    // + "name "
    // + "FROM "
    // + "country "
    // + "WHERE "
    // + "id = :id", nativeQuery = true)
    // ICountryDto getName(@Param("id") Long id);

    
}
