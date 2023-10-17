package com.gusticrud.crud.dao;

import com.gusticrud.crud.Controllers.models.usuarios;

import java.util.List;

public interface UsuarioDao {

    List<usuarios> getUsuarios();



    void eliminar(Long id);

    void registrar(usuarios usuario);

    usuarios obtenerUsuarioPorCredenciales(usuarios usuario);
}
