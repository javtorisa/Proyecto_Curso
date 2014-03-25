package com.plan.proyecto.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 */
@Entity
public class Avisos extends EntidadId{
    
    @ManyToOne
    private Usuario usuario;
    private String aviso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAviso;
    private String estado;

    public Avisos() {
    }

    public Avisos(Usuario usuario, String aviso, Date fechaAviso, String estado) {
        this.usuario = usuario;
        this.aviso = aviso;
        this.fechaAviso = fechaAviso;
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public Date getFechaAviso() {
        return fechaAviso;
    }

    public void setFechaAviso(Date fechaAviso) {
        this.fechaAviso = fechaAviso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String Estado) {
        this.estado = Estado;
    }
    

    
}
