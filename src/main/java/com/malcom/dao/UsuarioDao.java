package com.malcom.dao;

import com.malcom.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getAll();
    Usuario get(long id);
    Usuario post(Usuario user);
    Usuario put(Usuario user);
    void delete(long id);
    public Usuario login(Usuario user);
}
