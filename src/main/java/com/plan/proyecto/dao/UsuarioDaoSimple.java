package com.plan.proyecto.dao;

import com.plan.proyecto.beans.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public class UsuarioDaoSimple implements UsuarioDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        em.persist(usuario);
        return usuario;
    }

    @Override
    public Usuario buscaUsuario(String nombre) {
        Query q = em.createQuery("select u from Usuario u where u.nombre = :nombre");
        q.setParameter("nombre", nombre);
        try {
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuario buscaUsuarioporId(Long idUsuario) {
        return em.find(Usuario.class, idUsuario);

    }

    @Override
    public List<Usuario> listaUsuarios() {
        Query q = em.createQuery("select u from Usuario u");
        return q.getResultList();

    }

    @Override
    public List<Usuario> listaUsuariosNoAmigos(Long idUsuario) {
        Query q = em.createQuery("select u from Usuario u where u.id <> :id");
        q.setParameter("id", idUsuario);
        List <Usuario> lTodos = q.getResultList();
        Query q2 = em.createQuery("select u.amigos from Usuario u where u.id = :id");
        q2.setParameter("id", idUsuario);
        List <Usuario> lAmigos = q2.getResultList();
        List <Usuario> noAmigos = new ArrayList<>();
        for (Usuario esAmigo : lTodos){
            if (!lAmigos.contains(esAmigo)){
                noAmigos.add(esAmigo);
            }
        }
        return noAmigos;
    }

    @Override
    public List<Usuario> listaAmigos(Long idUsuario) {
        Query q = em.createQuery("select u.amigos from Usuario u where u.id = :id");
        q.setParameter("id", idUsuario);
        return q.getResultList();
    }

    @Override
    public Usuario actualizaUsuario(Usuario usuario) {
        return usuario;
    }

    @Override
    public List<Usuario> listaAmigosAccesibles(Long idUsuario) {
        Query q = em.createQuery("select u from Usuario u where u.id <> :id");
        q.setParameter("id", idUsuario);
        List<Usuario> lTodos = q.getResultList();
        Usuario usuario = buscaUsuarioporId(idUsuario);
        List<Usuario> amigosAcceso = new ArrayList<>();
        for (Usuario puedoAcceder : lTodos) {
            Query q2 = em.createQuery("select u.amigos from Usuario u where u.id = :idTodos");
            q2.setParameter("idTodos", puedoAcceder.getId());
            List<Usuario> lAmigosUsuario = q2.getResultList();
            if (lAmigosUsuario.contains(usuario)) {
                amigosAcceso.add(puedoAcceder);
            }
        }
        return amigosAcceso;
    }
}
