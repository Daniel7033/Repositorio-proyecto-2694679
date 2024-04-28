package com.sena.security.Entity.Tienda;

import com.sena.security.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto extends ABaseEntity{
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "short_description", length = 500, nullable = false)
    private String shortDescription;
    @Column(name = "long_description", length = 2000, nullable = false)
    private String longDescription;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "costo_precio", nullable = false)
    private Double costoPrecio;
    @Column(name = "descuento", nullable = false)
    private Double descuento;
    @Column(name = "iva", nullable = false)
    private Double iva;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public String getLongDescription() {
        return longDescription;
    }
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Double getCostoPrecio() {
        return costoPrecio;
    }
    public void setCostoPrecio(Double costoPrecio) {
        this.costoPrecio = costoPrecio;
    }
    public Double getDescuento() {
        return descuento;
    }
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    public Double getIva() {
        return iva;
    }
    public void setIva(Double iva) {
        this.iva = iva;
    }
    
}
