package com.malcom.dao.imp;

import com.malcom.dao.RolesDao;
import com.malcom.models.Roles;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class RolesDaoImp implements RolesDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Roles> getAll() {
        String hql = "FROM Role as u ";
        return (List<Roles>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public Roles get(long id) {
        return entityManager.find(Roles.class, id);
    }

    @Transactional
    @Override
    public Roles post(Roles role) {
        entityManager.merge(role);
        return role;
    }

    @Transactional
    @Override
    public Roles put(Roles role) {
        entityManager.merge(role);
        return role;
    }

    @Transactional
    @Override
    public void delete(long id) {
        Roles role = get(id);
        entityManager.remove(role);
    }
}
