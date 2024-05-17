package com.sena.security.IService;

import java.util.List;

import com.sena.security.DTO.ICountryDto;
import com.sena.security.Entity.Country;

public interface ICountryService extends IBaseService<Country> {
    String GeneratedCode(String name) throws Exception; //Generear código

    List<ICountryDto> getFiltrar(String code, String name); //Filtrar datos

    List<ICountryDto> getFiltrarEstado(Boolean state); //Filtrar datos por estado
}
