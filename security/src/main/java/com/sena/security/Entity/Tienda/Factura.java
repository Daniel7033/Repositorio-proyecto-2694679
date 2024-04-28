package com.sena.security.Entity.Tienda;

import com.sena.security.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura extends ABaseEntity {
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

}
