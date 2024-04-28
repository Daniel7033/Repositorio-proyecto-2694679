package com.sena.security.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.sena.security.Entity.ABaseEntity;
import com.sena.security.IRepository.IBaseRepository;
import com.sena.security.IService.IBaseService;

public abstract class ABaseService <T extends ABaseEntity> implements IBaseService<T>{
    
    protected abstract IBaseRepository<T, Long> getRepository();

    @Override
    public List<T> all() throws Exception{
        return getRepository().findAll();
    }

    @Override
    public List<T> findStateTrue() throws Exception{
        return getRepository().findAll();
    }

    @Override
    public Optional<T> findById(Long id) throws Exception {
        Optional<T> op = getRepository().findById(id);
        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } 
        return op;
    }

    @Override
    public T save(T entity) throws Exception {
        try {
            entity.setCreateAt(LocalDateTime.now());
            entity.setCreatedBy((long)1);
            return getRepository().save(entity);
        } catch (Exception e) {
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
    }

    @Override
    public void update(Long id, T entity) throws Exception{
        Optional<T> op = getRepository().findById(id);
        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (op.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }
        //Le asignamos a entityUpdate todo lo que op encuentre por id
        T entityUpdate = op.get();
        //Creamos un Array tipo String. Diciendole que al actualizar NO ACTUALICE los parametros esteblecidos
        String[] ignorePropierties = { "id", "createAt", "createBy", "deleteAt", "deleteBy"};
        BeanUtils.copyProperties(entity, entityUpdate, ignorePropierties);
        entityUpdate.setUpdatedAt(LocalDateTime.now());
        entityUpdate.setUpdatedBy((long)1);
        getRepository().save(entityUpdate);
    }

    @Override
    public void delete(Long id) throws Exception{
        Optional<T> op = getRepository().findById(id);
        if (op.isEmpty()){
            throw new Exception("Registro no encontrado");
        }
        T entityUpdate = op.get();
        entityUpdate.setDeletedAt(LocalDateTime.now());
        entityUpdate.setDeletedBy((long) 1);
        getRepository().save(entityUpdate);
    }
}
