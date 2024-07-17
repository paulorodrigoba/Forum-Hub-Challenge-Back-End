package br.com.forumhub.api.domain.topico;

import br.com.forumhub.api.domain.topico.DadosTopico;
import br.com.forumhub.api.domain.topico.ValidadoresTopico;
import br.com.forumhub.api.domain.validacao.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorNomeCurso implements ValidadoresTopico {

    @Override
    public void validar(DadosTopico dadosTopico) {
        var nomeCurso = dadosTopico.curso().getNomeCurso();
        if(nomeCurso.isEmpty()){
            throw new ValidacaoException("Nome do curso não pode estar vazio");
        }

    }
}
