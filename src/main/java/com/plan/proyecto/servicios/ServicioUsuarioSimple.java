package com.plan.proyecto.servicios;

import com.plan.proyecto.beans.ComentariosAmigos;
import com.plan.proyecto.beans.ContenidoMuro;
import com.plan.proyecto.beans.ContenidoMuroDTO;
import com.plan.proyecto.beans.Usuario;
import com.plan.proyecto.dao.MuroDao;
import com.plan.proyecto.dao.UsuarioDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 */
@Service
@Transactional
public class ServicioUsuarioSimple implements ServicioUsuario {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private MuroDao muroDao;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioDao.guardarUsuario(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscaUsuario(String nombre) {
        return usuarioDao.buscaUsuario(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscaUsuarioporId(Long idUsuario) {
        return usuarioDao.buscaUsuarioporId(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listaUsuarios() {
        return usuarioDao.listaUsuarios();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listaUsuariosNoAmigos(Long idUsuario) {
        return usuarioDao.listaUsuariosNoAmigos(idUsuario);
    }

    @Override
    public void crearContenidoMuro(ContenidoMuroDTO contenidoMuroDTO) {
        Usuario usuario = usuarioDao.buscaUsuarioporId(contenidoMuroDTO.getIdUsu());
        usuario.getContenidoMuro();
        ContenidoMuro cM = new ContenidoMuro();
        cM.setUsuario(usuario);
        cM.setFechaAlta(new Date());
        cM.setObjetoMuro(contenidoMuroDTO.getObjetoMuro());
        cM.setComentario(contenidoMuroDTO.getComentario());
        usuario.getContenidoMuro().add(cM);
        usuarioDao.guardarUsuario(usuario);
    }

    @Override
    public List<ContenidoMuro> listaContenidoMuro(Long idUsuario) {
        return muroDao.listaContenidoMuro(idUsuario);
    }

    @Override
    public void altaAmigo(Long idUsuario, Long idAmigo) {
        Usuario usuarioAmigo = usuarioDao.buscaUsuarioporId(idAmigo);
        Usuario usuarioOrigen = usuarioDao.buscaUsuarioporId(idUsuario);
        usuarioOrigen.getAmigos();
        usuarioOrigen.getAmigos().add(usuarioAmigo);
        usuarioDao.actualizaUsuario(usuarioOrigen);
    }

    @Override
    public void bajaAmigo(Long idUsuario, Long idAmigo) {
        Usuario usuarioAmigo = usuarioDao.buscaUsuarioporId(idAmigo);
        Usuario usuarioOrigen = usuarioDao.buscaUsuarioporId(idUsuario);
        usuarioOrigen.getAmigos();
        usuarioOrigen.getAmigos().remove(usuarioAmigo);
        usuarioDao.actualizaUsuario(usuarioOrigen);
    }

    @Override
    public List<Usuario> listaAmigos(Long idUsuario) {
        return usuarioDao.listaAmigos(idUsuario);
    }

    @Override
    public List<ComentariosAmigos> listaComentarios(Long idContenido) {
        return muroDao.listaComentarios(idContenido);
    }

    @Override
    public void altaComentario(ContenidoMuroDTO contenidoMuroDTO, Long idContenido, Long idUsu) {
        ContenidoMuro contenidoMuro = muroDao.buscaContenidoPorId(idContenido);
        Usuario usuarioComenta = usuarioDao.buscaUsuarioporId(idUsu);
        ComentariosAmigos comentariosAmigos = new ComentariosAmigos();
        comentariosAmigos.setComentarioAmigo(contenidoMuroDTO.getComentarioAmigo());
        comentariosAmigos.setFechaComentario(new Date());
        comentariosAmigos.setUsuarioComenta(usuarioComenta.getNombre());
        comentariosAmigos.setContenidoMuro(contenidoMuro);
        contenidoMuro.getComentariosAmigos();
        contenidoMuro.getComentariosAmigos().add(comentariosAmigos);
        muroDao.altaComentario(contenidoMuro);
    }

    @Override
    public ContenidoMuro buscaContenidoPorId(Long idContenido) {
        return muroDao.buscaContenidoPorId(idContenido);
    }

    @Override
    public List<Usuario> listaAmigosAccesibles(Long idUsuario) {
        return usuarioDao.listaAmigosAccesibles(idUsuario);
    }

}
