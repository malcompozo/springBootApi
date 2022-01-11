package com.malcom.controllers;

import com.malcom.models.Roles;
import com.malcom.services.RolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RolesController {

    @Autowired
    RolesService roleService;

    // Trae todos los usuarios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Roles> getAll() {
        return roleService.getAll();
    }

    // Trae todos los usuarios
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Roles get(@PathVariable long id) {
        return roleService.get(id);
    }

    // Registrar usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Roles register(@RequestBody Roles role) {
        return roleService.register(role);
    }

    // Registrar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Roles update(@RequestBody Roles role) {
        return roleService.update(role);
    }

    // Registrar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        roleService.delete(id);
    }
}
