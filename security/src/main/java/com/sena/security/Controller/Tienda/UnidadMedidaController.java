package com.sena.security.Controller.Tienda;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Tienda.UnidadMedida;
import com.sena.security.IService.Tienda.IUnidadMedidaService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/factura")
public class UnidadMedidaController extends ABaseController<UnidadMedida, IUnidadMedidaService>{

    public UnidadMedidaController(IUnidadMedidaService service){
        super(service, "UnidadMedida");
    }
    
}
