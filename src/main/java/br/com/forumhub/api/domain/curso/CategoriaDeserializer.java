package br.com.forumhub.api.domain.curso;

import br.com.forumhub.api.domain.validacao.ValidacaoException;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CategoriaDeserializer extends JsonDeserializer<Categoria> {

    @Override
    public Categoria deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String value = p.getText().toUpperCase();
        try {
            return Categoria.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new ValidacaoException("Categoria inválida");
        }
    }
}
