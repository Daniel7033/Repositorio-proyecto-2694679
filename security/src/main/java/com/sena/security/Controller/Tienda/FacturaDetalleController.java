package com.sena.security.Controller.Tienda;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Tienda.FacturaDetalle;
import com.sena.security.IService.Tienda.IFacturaDetalleService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/factura_detalle")
public class FacturaDetalleController extends ABaseController<FacturaDetalle, IFacturaDetalleService>{

    public FacturaDetalleController(IFacturaDetalleService service){
        super(service, "FacturaDetalle");
    }
    
}
