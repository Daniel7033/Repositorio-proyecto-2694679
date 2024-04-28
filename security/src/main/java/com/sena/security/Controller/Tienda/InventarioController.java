package com.sena.security.Controller.Tienda;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Tienda.Inventario;
import com.sena.security.IService.Tienda.IInventarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/inventario")
public class InventarioController extends ABaseController<Inventario, IInventarioService>{

    public InventarioController(IInventarioService service){
        super(service, "Inventario");
    }
    
}
