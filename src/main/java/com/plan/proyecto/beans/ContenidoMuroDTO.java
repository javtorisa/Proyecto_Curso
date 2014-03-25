package com.plan.proyecto.beans;

import org.springframework.stereotype.Component;

/**
 */
@Component
public class ContenidoMuroDTO {
    
    private Long idUsu;
    private String objetoMuro;
    private String comentario;
    private String comentarioAmigo;

    public ContenidoMuroDTO() {
    }

    public ContenidoMuroDTO(Long idUsu, String objetoMuro, String comentario, String comentarioAmigo) {
        this.idUsu = idUsu;
        this.objetoMuro = objetoMuro;
        this.comentario = comentario;
        this.comentarioAmigo = comentarioAmigo;
    }

    public Long getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Long idUsu) {
        this.idUsu = idUsu;
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

    public String getComentarioAmigo() {
        return comentarioAmigo;
    }

    public void setComentarioAmigo(String comentarioAmigo) {
        this.comentarioAmigo = comentarioAmigo;
    }


}
