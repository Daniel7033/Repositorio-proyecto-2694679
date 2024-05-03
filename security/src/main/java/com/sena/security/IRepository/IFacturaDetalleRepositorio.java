package com.sena.security.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.security.DTO.IFacturaDetalleDto;
import com.sena.security.Entity.FacturaDetalle;

@Repository
public interface IFacturaDetalleRepositorio extends IBaseRepository<FacturaDetalle, Long>{
    
    @Query(value = "select"
    +"fd.id,"   
    +"p.nombre AS 'Producto', "
    +"i.nombre AS 'Insumo',"
    +"(ip.cantidad * fd.cantidad) AS 'Cantidad', "
    +"um.nombre AS 'Unidad de medida'"
    +"from factura_detalle fd "
    +"inner join producto p on fd.producto_id = p.id "
    +"inner join insumo_producto ip on p.id = ip.producto_id "
    +"inner join insumo i on ip.insumo_id = i.id "
    +"inner join unidad_medida um on ip.unidad_medida_id = um.id "
    +"-- WHERE fd.id = 21; ", nativeQuery = true)
    List<IFacturaDetalleDto> getList();

}
