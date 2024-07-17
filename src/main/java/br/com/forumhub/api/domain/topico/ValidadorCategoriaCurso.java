package br.com.forumhub.api.domain.topico;


import br.com.forumhub.api.domain.validacao.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCategoriaCurso implements ValidadoresTopico{

    @Override
    public void validar(DadosTopico dadosTopico) {
        var categoriaCurso = dadosTopico.curso().getCategoria();

        if (categoriaCurso == null) {
            throw new ValidacaoException("Categoria não pode estar vazia");
        }

    }
}
