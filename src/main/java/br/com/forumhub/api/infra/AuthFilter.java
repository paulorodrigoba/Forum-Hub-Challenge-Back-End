package br.com.forumhub.api.infra;

import br.com.forumhub.api.domain.usuario.Usuario;
import br.com.forumhub.api.domain.usuario.UsuarioRepositorio;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);

        if(token != null) {
            Long subject = tokenService.getSubject(token);
            Usuario usuario = null;
            try {
                usuario = repositorio.findById(subject)
                        .orElseThrow(ChangeSetPersister.NotFoundException::new);
            } catch (ChangeSetPersister.NotFoundException e) {
                throw new RuntimeException(e);
            }
            var auth = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request,response);
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if(token != null && !token.isEmpty()) {
            return token.replace("Bearer ","");
        }

        return null;
    }
}