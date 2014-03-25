package com.plan.proyecto.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 */
@Entity
public class ComentariosAmigos extends EntidadId {

    @ManyToOne
    private ContenidoMuro contenidoMuro;
    private String comentarioAmigo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaComentario;
    private String usuarioComenta;

    public ComentariosAmigos() {
    }

    public ComentariosAmigos(ContenidoMuro contenidoMuro, String comentarioAmigo, Date fechaComentario, String usuarioComenta) {
        this.contenidoMuro = contenidoMuro;
        this.comentarioAmigo = comentarioAmigo;
        this.fechaComentario = fechaComentario;
        this.usuarioComenta = usuarioComenta;
    }

    public ContenidoMuro getContenidoMuro() {
        return contenidoMuro;
    }

    public void setContenidoMuro(ContenidoMuro contenidoMuro) {
        this.contenidoMuro = contenidoMuro;
    }

    public String getComentarioAmigo() {
        return comentarioAmigo;
    }

    public void setComentarioAmigo(String comentarioAmigo) {
        this.comentarioAmigo = comentarioAmigo;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getUsuarioComenta() {
        return usuarioComenta;
    }

    public void setUsuarioComenta(String usuarioComenta) {
        this.usuarioComenta = usuarioComenta;
    }

    
}
