package com.malcom.services;

import com.malcom.dao.UsuarioDao;
import com.malcom.models.Roles;
import com.malcom.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

//anotaciones de LOMBOK //
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Service // ANOTACION PARA INDICAR QUE ES UN SERVICIO //
public class UsuarioService {

    @Autowired
    UsuarioDao userDao;

    public List<Usuario> getAll() { return userDao.getAll(); }

    public Usuario get(long id) { return userDao.get(id); }
    
    public void post(@RequestBody Usuario user) { 
    	String hashString= generarHash(user.getPassword());
    	user.setPassword(hashString);
    	userDao.post(user); }

    public Usuario put(@RequestBody Usuario user) { return userDao.put(user); }

    public void delete(@PathVariable long id) { userDao.delete(id); }

    public Usuario login(Usuario user) { return userDao.login(user); }

    private String generarHash(String pass) {
		Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		return argon2.hash(1, 1024 * 1, 1, pass);
	}
    
}




