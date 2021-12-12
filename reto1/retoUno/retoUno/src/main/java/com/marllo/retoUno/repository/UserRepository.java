package com.marllo.retoUno.repository;


import com.marllo.retoUno.model.User;
import com.marllo.retoUno.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class UserRepository {
    //Genera Constructor
    @Autowired
    private UserCrudRepository userCrudRepository;
    //Este metodo viaja a la clase *userCrudRepository* busca todos los usuarios y los retorna en una lista
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    //Este metodo busca a un usuario por el id y lo trae.
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    //Este metodo guarda o actualiza un usuario
    public User save (User user){
        return userCrudRepository.save(user);
    }
    //Valida si el usuario es existente si no está retorna true el booleano está invertido
    public boolean existeEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail((email));

        return !usuario.isEmpty();
    }
    //Busca si el correo y contraseña estan en la base de datos
    public Optional<User> autenticarUsuario(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email,password);
    }

}
