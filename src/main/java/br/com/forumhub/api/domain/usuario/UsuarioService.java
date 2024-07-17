package br.com.forumhub.api.domain.usuario;

import br.com.forumhub.api.infra.RegisterException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepositorio repositorio;

    private final PasswordEncoder encoder;

    public DadosUsuario registrar (DadosRegistroUsuario dados){
        Optional<Usuario> registroUsuario = repositorio.findByEmail(dados.email());
        if (registroUsuario.isPresent()){
            throw new RegisterException("Email já registrado em nosso banco!");
        }
        Usuario usuario = repositorio.save(new Usuario(dados, encoder.encode(dados.senha())));
        return new DadosUsuario(repositorio.save(usuario));
    }
}
