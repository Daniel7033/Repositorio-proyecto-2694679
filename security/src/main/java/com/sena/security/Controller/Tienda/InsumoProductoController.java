package com.sena.security.Controller.Tienda;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Tienda.InsumoProducto;
import com.sena.security.IService.Tienda.IInsumoProductoService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/insumo_producto")
public class InsumoProductoController extends ABaseController<InsumoProducto, IInsumoProductoService>{

    public InsumoProductoController(IInsumoProductoService service){
        super(service, "InsumoProducto");
    }
    
}
