package com.gusticrud.crud.Controllers.models;

import com.gusticrud.crud.dao.UsuarioDao;
import com.gusticrud.crud.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AuthController {




        @Autowired
        private UsuarioDao usuarioDao;

        @Autowired
        private JWTUtil jwtUtil;

        @RequestMapping(value = "api/login", method = RequestMethod.POST)
        public String login(@RequestBody usuarios usuario) {

            usuarios usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
            if (usuarioLogueado != null) {
                String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
                return tokenJwt;
            }
            return "FAIL";
        }

    }

