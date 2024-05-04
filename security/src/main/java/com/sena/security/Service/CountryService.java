package com.sena.security.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.security.Entity.Country;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.ICountryRepository;
import com.sena.security.IService.ICountryService;

@Service
public class CountryService extends ABaseService<Country> implements ICountryService{
    @Autowired
    private ICountryRepository repository;

    @Override
    protected IBaseRepository<Country, Long> getRepository(){
        return repository;
    }

    @Override
    public Country save(Country entity) throws Exception{
        try {
            String digitos = entity.getName();
            int day = LocalDateTime.now().getDayOfMonth();
            String pd = digitos.substring(0, Math.min(digitos.length(), 3));
            String ud = digitos.substring(Math.max(0, digitos.length() - 3));
            String code = pd.toUpperCase() + day + ud.toUpperCase();
            entity.setCode(code);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setCreatedBy((long)1);
            return getRepository().save(entity);
        } catch (Exception e) {
            throw new Exception("Error con el codigo:" + e.getMessage());
        }
    }
}
