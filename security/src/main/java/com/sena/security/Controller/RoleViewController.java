package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.RoleView;
import com.sena.security.IService.IRoleViewService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/role-view")
public class RoleViewController extends ABaseController<RoleView, IRoleViewService>{

    protected RoleViewController(IRoleViewService service) {
        super(service, "RoleView");
    }
    
}
