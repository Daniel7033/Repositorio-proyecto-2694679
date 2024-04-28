package com.sena.security.Controller.Tienda;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Tienda.Factura;
import com.sena.security.IService.Tienda.IFacturaService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/factura")
public class FacturaController extends ABaseController<Factura, IFacturaService>{

    public FacturaController(IFacturaService service){
        super(service, "Factura");
    }
    
}
