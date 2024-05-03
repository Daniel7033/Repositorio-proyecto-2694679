package com.sena.security.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "insumo_producto")
public class InsumoProducto extends ABaseEntity{
    @Column(name = "cantidad", nullable = false)
    private String cantidad;
    @Column(name = "adicional", nullable = false)
    private Integer adicional;
    @Column(name = "precio_total", nullable = false)
    private Double precioTotal; 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unidad_medida_id", nullable = true)
    private UnidadMedida unidadMedida;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id", nullable = true)
    private Producto producto;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "insumo_id", nullable = true)
    private Insumo insumo;
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public Integer getAdicional() {
        return adicional;
    }
    public void setAdicional(Integer adicional) {
        this.adicional = adicional;
    }
    public Double getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Insumo getInsumo() {
        return insumo;
    }
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
    
}
