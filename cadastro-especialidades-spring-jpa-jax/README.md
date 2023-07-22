## Cadastro de Especialidades :clipboard:
>API REST para a gestão de funcionário de um empresa.  <br>
>É possível  consultar, cadastrar, editar e deletar profissionais e suas especialidades no banco de dados.<br>
❗ As tecnologias utilizadas foram o Java, spring, jpa e JAX-RS.

### Endpoints:
   
- **GET path = "/api/professional/all"**:<br>
Retorna todos os registros cadastrados dos profissionais e suas especialidades.<br>
Caso não encontre nenhum registro, retorna um `404 Not Found`, com a mensagem de erro:
"*Nenhum registro foi encontrado!*";
 
- **POST path = "/api/professional/add"**:<br>
Cadastra um novo registro no banco de dados com retorno `201 Created` e a string "*Inserido*".<br>
- **PUT path = "/api/professional/edit/{id}"**:<br>
Editar um registro já existente na base de dados, retorna um `200 Ok` e a string "*ID [%d] atualizado*", onde o `%d` representa o ID editado.<br>
O ID do cadastro é informado manualmente na URL e, caso ele não exista, um `404 Not Found` com a mensagem "
*Não é possível editar, o ID informado não existe*" deve ser retornado;
- **DELETE path = "/api/professional/delete/{id}"**:<br>
Deleta um registro já existente da base de dados, retorna um `200 Ok` e a string "*ID [%d] removido*", onde o `%d` representa o ID editado.<br>
O ID do cadastro é informado manualmente na URL e, caso ele não exista, um `404 Not Found` com a mensagem "*Não é possível deletar, o ID informado não existe*" é retornado;
