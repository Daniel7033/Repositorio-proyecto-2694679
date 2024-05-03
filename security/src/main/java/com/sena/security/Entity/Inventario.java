package com.sena.security.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario extends ABaseEntity{
    @Column(name = "code", nullable = false)
    private String code;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventario_detalle_id", nullable = true)
    private InventarioDetalle inventarioDetalle;
    
}
