package com.sena.security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.IService.IEnumService;
import com.sena.security.Utils.GeneroEnum;
import com.sena.security.Utils.NomenclaturaEnum;
import com.sena.security.Utils.TypeDocumentEnum;

import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/enum")
public class EnumController {
    @Autowired
    public IEnumService service;

    @GetMapping("/genero")
    public GeneroEnum[] getGenero(){
        return service.getGenero();
    }
    
    @GetMapping("/typeDocument")
    public TypeDocumentEnum[] getTypeDocument(){
        return service.getTypeDocument();
    }

    @GetMapping("/nomenclatura")
    public NomenclaturaEnum[] getNomenclatura(){
        return service.getNomenclatura();
    }
}
