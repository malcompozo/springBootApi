package com.malcom.dao;

import com.malcom.models.Roles;

import java.util.List;

public interface RolesDao {
    List<Roles> getAll();
    Roles get(long id);
    Roles post(Roles role);
    Roles put(Roles role);
    void delete(long id);
}
