package com.sena.security.Controller.Parameter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Parameter.City;
import com.sena.security.IService.Parameter.ICityService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/city")
public class CityController extends ABaseController<City, ICityService> {
    public CityController(ICityService service) {
        super(service, "City");
    }
}
