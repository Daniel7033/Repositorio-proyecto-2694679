package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.Insumo;
import com.sena.security.IService.IInsumoService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/insumo")
public class InsumoController extends ABaseController<Insumo, IInsumoService>{

    public InsumoController(IInsumoService service){
        super(service, "Insumo");
    }
    
}
