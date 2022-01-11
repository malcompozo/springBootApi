package com.malcom.controllers;

import com.malcom.models.Permiso;
import com.malcom.services.PermisoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permiso")
public class PermisoController {

    @Autowired
    PermisoService permisoService;

    // Trae todos los permisos
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permiso> getAll() {
        return permisoService.getAll();
    }

    // Trae todos los permisos
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permiso get(@PathVariable long id) {
        return permisoService.get(id);
    }

    // Registrar permiso
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permiso post(@RequestBody Permiso permiso) {
        return permisoService.post(permiso);
    }

    // Modificar permiso
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Permiso put(@RequestBody Permiso permiso) {
        return permisoService.put(permiso);
    }

    // Eliminar permiso
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        permisoService.delete(id);
    }
}
