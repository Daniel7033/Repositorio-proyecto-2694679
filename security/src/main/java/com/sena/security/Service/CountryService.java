package com.sena.security.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
//  Pendiente: Actualización del código automático de Country y revisar la efectividad de GeneratedCode {
        @Override
        public void update(Long id, Country entity) throws Exception{
            System.out.println("id " + id);
            Optional<Country> op = getRepository().findById(id);
            if (!op.isPresent()) {
                throw new Exception("Registro no encontrado");
            } 
            Country existent = op.get();
            if (!existent.getName().equals(entity.getName())) {
                String newCode = GeneratedCode(existent.getId(), existent.getName());
                existent.setCode(newCode);
            }
            String[] ingnorePropierties = {"id", "createdAt", "deletedAt", "createdBy", "deletedBy", "code"};
            BeanUtils.copyProperties(entity, existent, ingnorePropierties);
            existent.setUpdatedAt(LocalDateTime.now());
            existent.setUpdatedBy((long)id);
            getRepository().save(existent);
        }
        
        @Override
        public String GeneratedCode(Long id, String name) throws Exception{
            Optional<Country> op = getRepository().findById(id);
            Country ex = op.get();
            name = ex.getName();
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
//  }
}