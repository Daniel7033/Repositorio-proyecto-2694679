package com.sena.security.Entity.Tienda;

import com.sena.security.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario_detalle")
public class InventarioDetalle extends ABaseEntity{
    @Column(name = "code", nullable = false)
    private String code;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "insumo_id", nullable = true)
    private Insumo insumo;
}
