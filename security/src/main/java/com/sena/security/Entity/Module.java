package com.sena.security.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "module")
public class Module extends ABaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "route", nullable = false)
    private String route;

    @Column(name = "description", nullable = false)
    private String description;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "module_view", joinColumns = @JoinColumn (name = "module_id"), inverseJoinColumns = @JoinColumn (name = "view_id"))
    private Set<View> view = new HashSet();

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

    public Set<View> getView() {
        return view;
    }

    public void setView(Set<View> view) {
        this.view = view;
    }
    
}