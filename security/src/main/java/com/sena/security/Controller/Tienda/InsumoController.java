package com.sena.security.Controller.Tienda;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Tienda.Insumo;
import com.sena.security.IService.Tienda.IInsumoService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/insumo")
public class InsumoController extends ABaseController<Insumo, IInsumoService>{

    public InsumoController(IInsumoService service){
        super(service, "Insumo");
    }
    
}
