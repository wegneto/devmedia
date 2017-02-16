/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service.repositories;

import br.com.devmedia.cursojee.entities.Usuario;
import java.security.MessageDigest;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 43189334587
 */
public class UsuarioRepository extends BasicRepository {

    public UsuarioRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Usuario addUsuario(Usuario usuario) {
        usuario.setSenha(getMD5(usuario.getSenha()));
        addEntity(usuario);
        return usuario;
    }

    public Usuario getUsuario(int id) {
        return getEntity(Usuario.class, id);
    }
    
    public Usuario setUsuario(Usuario usuario) {
        return setEntity(usuario);
    }
    
    public void removeUsuario(Usuario usuario) {
        removeEntity(usuario);
    }
    
    public void setPassword(String password, int id) {
        String digest = getMD5(password);
        Usuario usuario = getUsuario(id);
        usuario.setSenha(digest);
        setUsuario(usuario);
    }

    public Usuario getUsuarioByLoginPassword(String login, String password) {
        String query = "select u from Usuario u where u.login = ?1 and u.senha = ?2";
        Usuario usr = getPojo(Usuario.class, query, login, getMD5(password));
        return usr;
    }
    
    public List<Usuario> getUsers() {
        String query = "select u from Usuario u";
        return getList(Usuario.class, query);
    }
    
    public List<Usuario> getDentistas() {
        String query = "select u from Usuario u where u.dentista = true";
        return getList(Usuario.class, query);
    }
    
    public List<Usuario> getUsuariosByName(String nome) {
        String query = "select u from Usuario u where u.nome like ?1";
        return getList(Usuario.class, query, nome+"%");
    }

    private String getMD5(String message) {
        String digest = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return digest;
    }

}
