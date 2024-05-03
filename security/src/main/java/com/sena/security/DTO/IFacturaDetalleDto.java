package com.sena.security.DTO;

public interface IFacturaDetalleDto extends IGenericDTO{
    String getProducto();
    String getInsumo();
    String getUnidadDeDetalle();
    Integer getCantidad();

    
}
