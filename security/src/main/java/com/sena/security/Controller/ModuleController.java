package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.Module;
import com.sena.security.IService.IModuleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/module")
public class ModuleController extends ABaseController<Module, IModuleService>{
    public ModuleController(IModuleService service, String entityName){
        super(service, "Module");
    }
}
