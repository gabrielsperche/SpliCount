package com.splitec.splicount.unittests.services.usuario;

import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.annotations.Fixture;
import org.bson.types.ObjectId;
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

        doAnswer(invocation -> {
            JFixture fixture = new JFixture();
            Usuario usuario = invocation.getArgument(0);
            if (usuario.getId() == null) {
                usuario.setId(fixture.create(ObjectId.class));
                _inMemoryDB.add(usuario);
            } else {
                Stream<Usuario> stream = _inMemoryDB.stream();
                Usuario usuarioPersistido = stream.filter(x -> x.getId().equals(usuario.getId())).findFirst().get();
                _inMemoryDB.remove(usuarioPersistido);
                _inMemoryDB.add(usuario);
            }
            return null;
        }).when(_repository).saveOrUpdate(any());

        doAnswer(invocation -> _inMemoryDB.stream().filter(x -> x.getId().equals(invocation.getArgument(0))).findFirst().get())
                .when(_repository).findById(any());

        doAnswer(invocation -> _inMemoryDB).when(_repository).findAll();

        doAnswer(invocation -> _inMemoryDB.remove(0)).when(_repository).deleteById(any());
    }

    @Test
    public void criarOuAtualizarUsuarioTest_whenInserirNovoUsuario() {
        //arrange
        String nome = "Teste";
        String senha = "12345";
        Usuario usuario = new Usuario(null, nome, senha);

        //act
        UsuarioService SUT = new UsuarioService(_repository);
        SUT.criarOuAtualizarUsuario(usuario);

        //assert
        Stream<Usuario> stream = _inMemoryDB.stream();

        Assertions.assertNotNull(_inMemoryDB.get(0));
        Assertions.assertEquals(1, _inMemoryDB.size());
    }

    @Test
    public void encontraPorIdTest() {
        //arrange
        JFixture fixture = new JFixture();
        ObjectId id = fixture.create(ObjectId.class);
        String nome = "Teste";
        String senha = "12345";
        Usuario usuario = new Usuario(id, nome, senha);
        _inMemoryDB.add(usuario);

        //act
        UsuarioService SUT = new UsuarioService(_repository);
        Usuario result = SUT.encontraPorId(id);

        //assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, usuario);
    }

    @Test
    public void listaTodosTest() {
        //arrange
        JFixture fixture = new JFixture();
        List<Usuario> usuarioList = createMany(5, fixture);
        _inMemoryDB.addAll(usuarioList);

        //act
        UsuarioService SUT = new UsuarioService(_repository);
        List<Usuario> result = SUT.listaTodos();

        //assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.size(), _inMemoryDB.size());
        Assertions.assertEquals(result, _inMemoryDB);
    }

    @Test
    public void criarOuAtualizar_WhenAtualizarUsuarioTest() {
        //arrange
        JFixture fixture = new JFixture();
        ObjectId id = fixture.create(ObjectId.class);
        String nome = "Teste";
        String senha = "12345";
        Usuario usuario = new Usuario(id, nome, senha);
        _inMemoryDB.add(usuario);
        Usuario modeloParaAtualizar = new Usuario(id, "Atualizado", "54321");

        //act
        UsuarioService SUT = new UsuarioService(_repository);
        SUT.criarOuAtualizarUsuario(modeloParaAtualizar);

        //assert
        Usuario usuarioAtualizado = _inMemoryDB.get(0);
        Assertions.assertNotNull(usuarioAtualizado);
        Assertions.assertNotEquals(usuario.getNome(), modeloParaAtualizar.getNome());
    }

    @Test
    public void deletarTest() {
        //arrange
        JFixture fixture = new JFixture();
        ObjectId id = fixture.create(ObjectId.class);
        String nome = "Teste";
        String senha = "12345";
        Usuario usuario = new Usuario(id, nome, senha);
        _inMemoryDB.add(usuario);

        //act
        UsuarioService SUT = new UsuarioService(_repository);
        SUT.deletar(id);

        //assert
        Assertions.assertEquals(_inMemoryDB.size(), 0);
    }

    public List<Usuario> createMany(int count, JFixture fixture) {
        List<Usuario> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(fixture.create(Usuario.class));
        }
        return result;
    }
}
