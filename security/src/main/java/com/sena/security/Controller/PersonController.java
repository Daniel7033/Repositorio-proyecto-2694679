package com.sena.security.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Entity.Person;
import com.sena.security.IService.IPersonService;

@CrossOrigin(origins =  "*")
@RestController
@RequestMapping("v1/api/person")
public class PersonController extends ABaseController<Person, IPersonService>{

    public PersonController(IPersonService service, String entityName) {
        super(service, "Person");
    }
    
    //..............
}
