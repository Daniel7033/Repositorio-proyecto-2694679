package com.sena.security.Controller.Tienda;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Tienda.Producto;
import com.sena.security.IService.Tienda.IProductoService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/producto")
public class ProductoController extends ABaseController<Producto, IProductoService>{

    public ProductoController(IProductoService service){
        super(service, "Producto");
    }
    
}
