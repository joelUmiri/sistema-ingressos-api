package br.com.joel.sistemaingressos.service;

import br.com.joel.sistemaingressos.entity.Usuario;
import br.com.joel.sistemaingressos.exception.UsuarioNaoEncontradoException;
import br.com.joel.sistemaingressos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastroUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(UUID id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));
    }

    public Usuario atualizarUsuario(UUID id, Usuario usuario) {
        Usuario usuarioExistente = buscarUsuarioPorId(id);
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setEmail(usuario.getEmail());
        return usuarioRepository.save(usuarioExistente);
    }

    public void excluirUsuario(UUID id) {
        buscarUsuarioPorId(id);
        usuarioRepository.deleteById(id);
    }


}
