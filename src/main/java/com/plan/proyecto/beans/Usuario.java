package com.plan.proyecto.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 */
@Entity
public class Usuario extends EntidadId {
    
    private String nombre;
    private String clave;
    private String apellidos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAlta;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> amigos = new ArrayList<>();
    @OneToMany(orphanRemoval = true, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Avisos> avisos;
    @OneToMany(orphanRemoval = true, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ContenidoMuro> contenidoMuro;

    public Usuario() {
    }

    public Usuario(String nombre, String clave, String apellidos, Date fechaAlta, List<Avisos> avisos, List<ContenidoMuro> contenidoMuro) {
        this.nombre = nombre;
        this.clave = clave;
        this.apellidos = apellidos;
        this.fechaAlta = fechaAlta;
        this.avisos = avisos;
        this.contenidoMuro = contenidoMuro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Avisos> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<Avisos> avisos) {
        this.avisos = avisos;
    }

    public List<ContenidoMuro> getContenidoMuro() {
        return contenidoMuro;
    }

    public void setContenidoMuro(List<ContenidoMuro> contenidoMuro) {
        this.contenidoMuro = contenidoMuro;
    }
        
}
