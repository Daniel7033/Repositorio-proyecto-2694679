package com.sena.security.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.DTO.ICountryDto;
import com.sena.security.Entity.Country;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.ICountryRepository;
import com.sena.security.IService.ICountryService;

@Service
public class CountryService extends ABaseService<Country> implements ICountryService {
    @Autowired
    private ICountryRepository repository;

    @Override
    protected IBaseRepository<Country, Long> getRepository() {
        return repository;
    }

    @Override
    public Country save(Country entity) throws Exception {
        try {
            String digitos = entity.getName();
            int day = LocalDateTime.now().getDayOfMonth();
            String pd = digitos.substring(0, Math.min(digitos.length(), 3));
            String ud = digitos.substring(Math.max(0, digitos.length() - 3));
            String code = pd.toUpperCase() + day + ud.toUpperCase();
            entity.setCode(code);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setCreatedBy((long) 1);
            return getRepository().save(entity);
        } catch (Exception e) {
            throw new Exception("Error con el codigo:" + e.getMessage());
        }
    }

    @Override
    public void update(Long id, Country entity) throws Exception {
        Optional<Country> op = getRepository().findById(id);
        if (!op.isPresent()) {
            throw new Exception("País no encontrado");
        }
        Country existent = op.get();
        String oldName = existent.getName();
        String newName = entity.getName();
        if (!oldName.equals(newName)) {
            existent.setName(newName);
            String newCode = GeneratedCode(newName);
            existent.setCode(newCode);
        }
        String[] ingnorePropierties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy", "code" };
        BeanUtils.copyProperties(entity, existent, ingnorePropierties);
        existent.setUpdatedAt(LocalDateTime.now());
        existent.setUpdatedBy((long) id);
        getRepository().save(existent);
    }

    /* 
     * ******************************
     * Metodos extras...
     * ******************************
     */

    @Override
    public String GeneratedCode(String name) throws Exception { //Generar código automático
        if (name.length() >= 3) {
            int day = LocalDateTime.now().getDayOfMonth();
            String pd = name.substring(0, Math.min(name.length(), 3));
            String ud = name.substring(Math.max(0, name.length() - 3));
            String code = pd.toUpperCase() + day + ud.toUpperCase();
            return code;

        } else {
            throw new IllegalArgumentException("Error al generar el código.");
        }
    }

    @Override
    public List<ICountryDto> getFiltrar(String code, String name){ //Filtrar datos
        return repository.getFiltrar(code, name);
    }

    @Override
    public List<ICountryDto> getFiltrarEstado(Boolean state){ //Filtrar datos por estado
        return repository.getFiltrarEstado(state);
    }
}