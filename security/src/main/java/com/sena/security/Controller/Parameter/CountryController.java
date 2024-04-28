package com.sena.security.Controller.Parameter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.Controller.ABaseController;
import com.sena.security.Entity.Parameter.Country;
import com.sena.security.IService.Parameter.ICountryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/country")
public class CountryController extends ABaseController<Country, ICountryService>{
    public CountryController (ICountryService service){
        super(service, "Country");
    }
}
