package com.sena.security.IService;

import java.util.List;

import com.sena.security.DTO.IFacturaDetalleDto;
import com.sena.security.Entity.FacturaDetalle;

public interface IFacturaDetalleService extends  IBaseService<FacturaDetalle>{
    
    List<IFacturaDetalleDto> getList();
}
