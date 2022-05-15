package com.splitec.splicount.unittests.services.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import splitec.entities.Usuario;
import splitec.repository.UsuarioRepository;
import splitec.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

public class UsuarioServiceTestCase {

    List<Usuario> _inMemoryDB = new ArrayList<>();
    UsuarioRepository _repository;

    public UsuarioServiceTestCase() {
        MockDependencies();
    }

    private void InitStubs() {

    }

    private void MockDependencies() {
        _repository = mock(UsuarioRepository.class);
        doAnswer(invocation -> _inMemoryDB.add(invocation.getArgument(0))).when(_repository).saveOrUpdate(any());
    }

    @Test
    public void criarUsuarioTest() {
        //arrange
        String nome = "Teste";
        String senha = "12345";
        Usuario usuario = new Usuario(null, nome, senha);

        //act
        UsuarioService SUT = new UsuarioService(_repository);
        SUT.criarUsuario(usuario);

        //assert
        Stream<Usuario> stream = _inMemoryDB.stream();

        Assertions.assertNotNull(_inMemoryDB.get(0));
        Assertions.assertEquals(1, _inMemoryDB.size());
    }

    @Test
    public void encontrarUsuarioTest() {
        //arrange
        String nome = "Teste";
        String senha = "12345";
        Usuario usuario = new Usuario(null, nome, senha);

        //act
        UsuarioService SUT = new UsuarioService(_repository);
        SUT.criarUsuario(usuario);

        //assert
        Stream<Usuario> stream = _inMemoryDB.stream();

        Assertions.assertNotNull(_inMemoryDB.get(0));
        Assertions.assertEquals(1, _inMemoryDB.size());
    }

}
