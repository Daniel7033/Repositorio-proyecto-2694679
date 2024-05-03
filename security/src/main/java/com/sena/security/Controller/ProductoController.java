package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.Producto;
import com.sena.security.IService.IProductoService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/producto")
public class ProductoController extends ABaseController<Producto, IProductoService>{

    public ProductoController(IProductoService service){
        super(service, "Producto");
    }
    
}
