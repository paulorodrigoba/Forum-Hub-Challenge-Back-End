package br.com.forumhub.api.domain.topico;


import br.com.forumhub.api.domain.validacao.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMensagem implements ValidadoresTopico{

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DadosTopico dadosTopico) {
        var mensagem = dadosTopico.mensagem();

        if(mensagem.isEmpty()){
            throw new ValidacaoException("Mensagem não pode estar vazia");
        }

        var mensagemExiste = repository.acheMensagem(mensagem);
        if(mensagemExiste){
            throw new ValidacaoException("Mensagem já existe");
        }


    }
}
