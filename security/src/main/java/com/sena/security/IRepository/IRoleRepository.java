package com.sena.security.IRepository;

import org.springframework.stereotype.Repository;
import com.sena.security.Entity.Role;

@Repository
public interface IRoleRepository extends IBaseRepository<Role, Long>{
    
}
