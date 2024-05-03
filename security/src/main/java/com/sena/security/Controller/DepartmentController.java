package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.Department;
import com.sena.security.IService.IDepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/department")
public class DepartmentController extends ABaseController<Department, IDepartmentService>{
    public DepartmentController (IDepartmentService service){
        super(service, "Department");
    }
}
