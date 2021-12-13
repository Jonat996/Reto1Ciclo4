package com.marllo.retoUno.controller;

import com.marllo.retoUno.model.User;
import com.marllo.retoUno.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    @PostMapping("/new")
@ResponseStatus(HttpStatus.CREATED)
    public  User registrar(@RequestBody User user){
        return userService.registrar(user);
    }

    @GetMapping("/{email}{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticarUsuario(email, password);
    }
    @GetMapping("/{email}")
        public boolean existeEmail(@PathVariable("email") String email){
        return  userService.existeEmail(email);
    }

}
