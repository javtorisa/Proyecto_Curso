package com.plan.proyecto.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 */
@Entity
public class ContenidoMuro extends EntidadId{
    
    private String objetoMuro;
    private String comentario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAlta;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(orphanRemoval = true, mappedBy = "contenidoMuro", cascade = CascadeType.ALL)
    List<ComentariosAmigos> comentariosAmigos;

    public ContenidoMuro() {
    }

    public ContenidoMuro(String objetoMuro, String comentario, Date fechaAlta, Usuario usuario, List<ComentariosAmigos> comentariosAmigos) {
        this.objetoMuro = objetoMuro;
        this.comentario = comentario;
        this.fechaAlta = fechaAlta;
        this.usuario = usuario;
        this.comentariosAmigos = comentariosAmigos;
    }

    public String getObjetoMuro() {
        return objetoMuro;
    }

    public void setObjetoMuro(String objetoMuro) {
        this.objetoMuro = objetoMuro;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ComentariosAmigos> getComentariosAmigos() {
        return comentariosAmigos;
    }

    public void setComentariosAmigos(List<ComentariosAmigos> comentariosAmigos) {
        this.comentariosAmigos = comentariosAmigos;
    }

    
}
