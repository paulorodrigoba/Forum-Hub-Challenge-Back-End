ALTER TABLE topicos ADD ativo TINYINT;
UPDATE topicos SET ativo = 1;

alter table topicos add column autor_id BIGINT;
alter table topicos add foreign key (autor_id) references usuarios(id);