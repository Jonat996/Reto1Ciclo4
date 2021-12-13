package com.marllo.retoUno.repository.crud;

import com.marllo.retoUno.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//Dentro de los valores va primero la clase en donde tenemos los campos de la tabla, segundo valor tipo de dato
//de la llave primaria
public interface UserCrudRepository extends CrudRepository<User,Integer> {
    //dentro de los parametros tiene que ir un atributo que coincida con la clase User,
    //ya que este irá hasta la clase User en busca de ese mismo atributo.
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
