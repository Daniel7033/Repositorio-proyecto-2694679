package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.Inventario;
import com.sena.security.IService.IInventarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/inventario")
public class InventarioController extends ABaseController<Inventario, IInventarioService>{

    public InventarioController(IInventarioService service){
        super(service, "Inventario");
    }
    
}
