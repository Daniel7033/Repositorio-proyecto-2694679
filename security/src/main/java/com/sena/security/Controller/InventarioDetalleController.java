package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.InventarioDetalle;
import com.sena.security.IService.IInventarioDetalleService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/inventario_detalle")
public class InventarioDetalleController extends ABaseController<InventarioDetalle, IInventarioDetalleService>{

    public InventarioDetalleController(IInventarioDetalleService service){
        super(service, "InventarioDetalle");
    }
    
}
