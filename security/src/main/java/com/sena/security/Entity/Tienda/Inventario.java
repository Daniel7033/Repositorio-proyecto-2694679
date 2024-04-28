package com.sena.security.Entity.Tienda;

import com.sena.security.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario extends ABaseEntity{
    @Column(name = "code", nullable = false)
    private String code;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventario_detalle_id", nullable = true)
    private InventarioDetalle inventarioDetalle;
}
