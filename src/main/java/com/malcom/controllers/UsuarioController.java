package com.malcom.controllers;

import com.malcom.models.Usuario;
import com.malcom.services.UsuarioService;
import com.malcom.utils.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UsuarioController {

    @Autowired
    UsuarioService userService;
    @Autowired
    private JWTUtil jwtUtil;

    // Trae todos los usuarios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Usuario> getAll() {
        return userService.getAll();
    }

    // Trae todos los usuarios
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Usuario get(@PathVariable long id) {
        return userService.get(id);
    }

    // Registrar usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    void post(@RequestBody Usuario user) {
        userService.post(user);
    }

    // Registrar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Usuario put(@RequestBody Usuario user) {
        return userService.put(user);
    }

    // Registrar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        userService.delete(id);
    }

    // login de usuario
    @RequestMapping (value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody Usuario dto){
    	Usuario user= userService.login(dto);
    	
    	Map<String, Object> result = new HashMap<>();
    	if (user != null) {
            String token = jwtUtil.create(String.valueOf(user.getId()),user.getEmail());
            result.put("token", token);
            result.put("user", user);

        }

        return result;
    }

}
