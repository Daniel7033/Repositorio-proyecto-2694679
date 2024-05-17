package com.sena.security.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.sena.security.DTO.ICountryDto;
import com.sena.security.Entity.Country;
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
/* Pendiente
    @Override
    public void update(Long id, Department entity) throws Exception{
        Optional<Department> opDepa = getRepository().findById(id);
        if (opDepa.isEmpty()) {
            throw new Exception("Departamento no encontrado.");
        } else if (opDepa.get().getDeletedAt() != null) {
            throw new Exception("Departamento no encontrado..");
        }
        Department existentDepa = opDepa.get();
        Country exCountry = existentDepa.getCountry();
        if (!exCountry.getName().equals(entity.getCountry().getName())) {
            Country country = entity.getCountry();
            System.out.println("getName " + country.getName());
            String newCode = GeneratedCode(country.getId(), country.getName());
            existentDepa.setCode(newCode);
        }
        String[] ingnorePropierties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy", "code" };
        BeanUtils.copyProperties(entity, existentDepa, ingnorePropierties);
        existentDepa.setUpdatedAt(LocalDateTime.now());
        existentDepa.setUpdatedBy((long) id);
        getRepository().save(existentDepa);
    }

    @Override
    public String GeneratedCode(Long country, String name) throws Exception{
        Optional<Country> opCountry = countryService.findById(country);
        if (opCountry.isPresent()) {
            System.out.println(name);
            if (name.length() >= 3) {
                Country countryN = opCountry.get();
                String digitoC = countryN.getName();
                int day = LocalDateTime.now().getDayOfMonth();
                String pd = name.substring(0, Math.min(digitoC.length(), 3));
                String ud = name.substring(Math.max(0, name.length() - 3));
                String code = pd.toUpperCase() + day + ud.toUpperCase();
                return code;
            } else {
                throw new IllegalArgumentException("Name length is less than 3 characters");
            }
        } else {
            throw new Error("País no encontrado.");
        }
    } */
}
