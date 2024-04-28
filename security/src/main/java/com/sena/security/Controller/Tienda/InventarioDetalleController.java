package com.sena.security.Controller.Tienda;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Tienda.InventarioDetalle;
import com.sena.security.IService.Tienda.IInventarioDetalleService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/inventario_detalle")
public class InventarioDetalleController extends ABaseController<InventarioDetalle, IInventarioDetalleService>{

    public InventarioDetalleController(IInventarioDetalleService service){
        super(service, "InventarioDetalle");
    }
    
}
