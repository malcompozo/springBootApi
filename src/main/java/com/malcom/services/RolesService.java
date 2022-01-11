package com.malcom.services;

import com.malcom.dao.RolesDao;
import com.malcom.models.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    RolesDao roleDao;

    public List<Roles> getAll() {
        return roleDao.getAll();
    }

    public Roles get(long id) {
        return roleDao.get(id);
    }

    public Roles register(Roles role) {
        return roleDao.post(role);
    }

    public Roles update(@RequestBody Roles role) {
        return roleDao.put(role);
    }

    public void delete(@PathVariable long id) {
        roleDao.delete(id);
    }
}
