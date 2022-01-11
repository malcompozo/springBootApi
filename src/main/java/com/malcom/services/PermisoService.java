package com.malcom.services;

import com.malcom.dao.PermisoDao;
import com.malcom.models.Permiso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PermisoService {

    @Autowired
    PermisoDao permisoDao;

    public List<Permiso> getAll() {
        return permisoDao.getAll();
    }

    public Permiso get(long id) {
        return permisoDao.get(id);
    }

    public Permiso post(Permiso permiso) {
        return permisoDao.post(permiso);
    }

    public Permiso put(@RequestBody Permiso permiso) {
        return permisoDao.put(permiso);
    }

    public void delete(@PathVariable long id) {
        permisoDao.delete(id);
    }
}
