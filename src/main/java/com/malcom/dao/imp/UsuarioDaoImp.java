package com.malcom.dao.imp;

import com.malcom.dao.UsuarioDao;
import com.malcom.models.Usuario;

import antlr.StringUtils;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository // ANOTACION PARA ACCEDER A LA BBDD
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Usuario> getAll() {
        String hql = "FROM User as u ";
        return (List<Usuario>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Usuario get(long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public Usuario post(Usuario user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public Usuario put(Usuario user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public void delete(long id) {
        Usuario user = get(id);
        entityManager.remove(user);
    }

	@Override
	public Usuario login(Usuario user) {
		 boolean isAuthenticated = false;

	        String hql = "FROM User as u WHERE u.password is not null and u.email = :email";

	        List<Usuario> result = entityManager.createQuery(hql.toString()).setParameter("email", user.getEmail()).getResultList();
	        if (result.size() == 0) { return null; }
	        Usuario dto = result.get(0);
	        isAuthenticated = true;
	        if (dto.getPassword().isEmpty()) {
	            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
	            isAuthenticated = argon2.verify(user.getPassword(), user.getPassword());
	        }
	        if (isAuthenticated) {
	            return user;
	        }
	        return null;

	    }

}
