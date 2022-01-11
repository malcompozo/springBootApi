package com.malcom.dao;

import com.malcom.models.Permiso;

import java.util.List;

public interface PermisoDao {
    List<Permiso> getAll();
    Permiso get(long id);
    Permiso post(Permiso permiso);
    Permiso put(Permiso permiso);
    void delete(long id);
}
