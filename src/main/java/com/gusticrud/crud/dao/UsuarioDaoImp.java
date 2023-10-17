package com.gusticrud.crud.dao;

import com.gusticrud.crud.Controllers.models.usuarios;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class UsuarioDaoImp implements UsuarioDao {


    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<usuarios> getUsuarios() {
        String query = "FROM usuarios";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        usuarios usuario = entityManager.find(usuarios.class, id);
        entityManager.remove(usuario);

    }

    @Override
    public void registrar(usuarios usuario) {

        entityManager.merge(usuario);



    }
}
