package com.sena.security.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.sena.security.DTO.ICountryDto;
import com.sena.security.Entity.Department;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IRepository.IDepartmentRepository;
import com.sena.security.IService.ICountryService;
import com.sena.security.IService.IDepartmentService;

@Service
public class DepartmentService extends ABaseService<Department> implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Override
    protected IBaseRepository<Department, Long> getRepository(){
        return repository;
    }

    @Lazy
    private final ICountryService countryService;

    public DepartmentService(@Lazy ICountryService countryService, IDepartmentRepository repository){
        this.repository = repository;
        this.countryService = countryService;
    }

    @Override
    public Department save(Department entity) throws Exception{
        try{
        ICountryDto country = repository.getName(entity.getCountry().getId());
        String digitoCountry = country.getName();
        String digitoDepa = entity.getName();
        int day = LocalDateTime.now().getDayOfMonth();
        String pd = digitoCountry.substring(0, Math.min(digitoCountry.length(), 3));
        String ud = digitoDepa.substring(Math.max(0, digitoDepa.length() - 3));
        String code = pd.toUpperCase() + day + ud.toUpperCase();
        entity.setCode(code);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setCreatedBy((long)1);
        return getRepository().save(entity);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al guardar el código" + e.getMessage());
        }
    }
}
