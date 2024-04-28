package com.sena.security.IService;

import com.sena.security.Utils.GeneroEnum;
import com.sena.security.Utils.NomenclaturaEnum;
import com.sena.security.Utils.TypeDocumentEnum;

public interface IEnumService {
    GeneroEnum[] getGenero();

    TypeDocumentEnum[] getTypeDocument();

    NomenclaturaEnum[] getNomenclatura();
}
