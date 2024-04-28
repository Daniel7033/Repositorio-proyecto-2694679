package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.View;
import com.sena.security.IService.IViewService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/view")
public class ViewController extends ABaseController<View, IViewService> {
    public ViewController(IViewService service, String entityName){
        super(service, "View");
    }
}
