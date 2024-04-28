package com.sena.security.Controller.Parameter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Parameter.Department;
import com.sena.security.IService.Parameter.IDepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/department")
public class DepartmentController extends ABaseController<Department, IDepartmentService>{
    public DepartmentController (IDepartmentService service){
        super(service, "Department");
    }
}
