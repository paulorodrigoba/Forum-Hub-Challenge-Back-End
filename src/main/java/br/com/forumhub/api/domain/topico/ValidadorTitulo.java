package br.com.forumhub.api.domain.topico;

import br.com.forumhub.api.domain.topico.DadosTopico;
import br.com.forumhub.api.domain.topico.TopicoRepository;
import br.com.forumhub.api.domain.topico.ValidadoresTopico;
import br.com.forumhub.api.domain.validacao.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTitulo implements ValidadoresTopico {

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DadosTopico dadosTopico) {
        var titulo = dadosTopico.titulo();

        if(titulo.isEmpty()){
            throw new ValidacaoException("Título não pode estar vazio");
        }

        var tituloExiste = repository.acheTitulo(titulo);
        if(tituloExiste){
            throw new ValidacaoException("Título já existe");
        }
    }
}
