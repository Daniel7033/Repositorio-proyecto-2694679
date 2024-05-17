package com.sena.security.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.DTO.ApiResponseDto;
import com.sena.security.DTO.ICountryDto;
import com.sena.security.Entity.Country;
import com.sena.security.IService.ICountryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/country")
public class CountryController extends ABaseController<Country, ICountryService> {
    public CountryController(ICountryService service) {
        super(service, "Country");
    }

    // Filtrar datos
    @GetMapping("/filtrar/")
    public ResponseEntity<ApiResponseDto<List<ICountryDto>>> show(@RequestParam(required = false) String code,
            @RequestParam(required = false) String name) {
        try {
            List<ICountryDto> entity;
            if (code != null && name != null) {
                entity = service.getFiltrar(code, name);
            } else if (code != null && name == null) {
                entity = service.getFiltrar(code, null);
            } else if (code == null && name != null) {
                entity = service.getFiltrar(null, name);
            } else {
                return ResponseEntity.ok(new ApiResponseDto<>("ERROR: Se requiere uno de los parametros solicitantes.", null, true));
            }
            return ResponseEntity.ok(new ApiResponseDto<>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<List<ICountryDto>>(e.getMessage(), null, false));
        }
    }

    // Filtrar datos por estado
    @GetMapping("/filtrar/{state}")
    public ResponseEntity<ApiResponseDto<List<ICountryDto>>> show(@PathVariable Boolean state) {
        try {
            List<ICountryDto> entity = service.getFiltrarEstado(state);
            return ResponseEntity.ok(new ApiResponseDto<List<ICountryDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<List<ICountryDto>>(e.getMessage(), null, false));
        }
    }
}
