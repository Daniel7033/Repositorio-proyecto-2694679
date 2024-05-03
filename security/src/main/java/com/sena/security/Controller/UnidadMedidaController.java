package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.UnidadMedida;
import com.sena.security.IService.IUnidadMedidaService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/unidad_medida")
public class UnidadMedidaController extends ABaseController<UnidadMedida, IUnidadMedidaService>{

    public UnidadMedidaController(IUnidadMedidaService service){
        super(service, "UnidadMedida");
    }
    
}
