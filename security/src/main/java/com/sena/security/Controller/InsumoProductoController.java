package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.InsumoProducto;
import com.sena.security.IService.IInsumoProductoService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/insumo_producto")
public class InsumoProductoController extends ABaseController<InsumoProducto, IInsumoProductoService>{

    public InsumoProductoController(IInsumoProductoService service){
        super(service, "InsumoProducto");
    }
    
}
