package com.malcom.dao.imp;

import com.malcom.dao.PermisoDao;
import com.malcom.models.Permiso;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PermisoDaoImp implements PermisoDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Permiso> getAll() {
        String hql = "FROM Permiso as u ";
        return (List<Permiso>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public Permiso get(long id) {
        return entityManager.find(Permiso.class, id);
    }

    @Transactional
    @Override
    public Permiso post(Permiso permiso) {
        entityManager.merge(permiso);
        return permiso;
    }

    @Transactional
    @Override
    public Permiso put(Permiso permiso) {
        entityManager.merge(permiso);
        return permiso;
    }

    @Transactional
    @Override
    public void delete(long id) {
        Permiso permiso = get(id);
        entityManager.remove(permiso);
    }
}
