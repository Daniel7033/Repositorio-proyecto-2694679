package com.sena.security.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "module")
public class Module extends ABaseEntity{
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "route", length = 50, nullable = false)
    private String route;

    @Column(name = "description", length = 10000)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
