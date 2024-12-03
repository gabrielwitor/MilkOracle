package com.util;

import com.model.Cow;
import com.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DaoTest {

    @Test
    public void testInserirUsuarioAdmin() {
        User user = new User("admin", GerenciadorDeSenhas.gerarHashSenha("1234"), "admin");
        Dao<User> dao = new Dao(User.class);
        dao.inserir(user);
    }

    @Test
    public void testInserirUsuario() {
        User user = new User("user", GerenciadorDeSenhas.gerarHashSenha("1234"), "user");
        Dao<User> dao = new Dao(User.class);
        dao.inserir(user);
    }

    @Test
    public void testInserirVaca() {
        Cow cow = new Cow("A1","Mimosa","Gir");
        Dao<Cow> dao = new Dao(Cow.class);
        dao.inserir(cow);
    }

    @Test
    public void testBuscarPorChave(){
        Dao<User> dao = new Dao(User.class);
        User user = dao.buscarPorChave("nome", "Rafael");
        System.out.println(user.getPassword());
    }


}