package com.sena.security.Service;

import org.springframework.stereotype.Service;

import com.sena.security.IService.IEnumService;
import com.sena.security.Utils.GeneroEnum;
import com.sena.security.Utils.NomenclaturaEnum;
import com.sena.security.Utils.TypeDocumentEnum;

@Service
public class EnumService implements IEnumService{

    @Override
    public GeneroEnum[] getGenero() {
        return GeneroEnum.values();
    }

    @Override
    public TypeDocumentEnum[] getTypeDocument() {
        return TypeDocumentEnum.values();
    }

    @Override
    public NomenclaturaEnum[] getNomenclatura() {
        return NomenclaturaEnum.values();
    }

}
