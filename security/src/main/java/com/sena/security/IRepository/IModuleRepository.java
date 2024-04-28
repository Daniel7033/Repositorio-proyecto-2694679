package com.sena.security.IRepository;

import org.springframework.stereotype.Repository;
import com.sena.security.Entity.Module;

@Repository
public interface IModuleRepository extends IBaseRepository<Module, Long>{
    
}
