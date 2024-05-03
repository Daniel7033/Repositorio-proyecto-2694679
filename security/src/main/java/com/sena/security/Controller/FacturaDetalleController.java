package com.sena.security.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.security.DTO.ApiResponseDto;
import com.sena.security.DTO.IFacturaDetalleDto;
import com.sena.security.Entity.FacturaDetalle;
import com.sena.security.IService.IFacturaDetalleService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/factura_detalle")
public class FacturaDetalleController extends ABaseController<FacturaDetalle, IFacturaDetalleService>{

    public FacturaDetalleController(IFacturaDetalleService service){
        super(service, "FacturaDetalle");
    }

    @GetMapping("/salida")
    public ResponseEntity<ApiResponseDto<List<IFacturaDetalleDto>>> show(){
        try {
            List<IFacturaDetalleDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IFacturaDetalleDto>>("Datos de salida", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IFacturaDetalleDto>>(e.getMessage(), null, false));
        }
    }
    
}
