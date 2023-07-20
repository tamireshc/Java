# Minhas Séries :movie_camera:

A aplicação minhas séries é uma API REST para gestão de séries vistas por um usuário.<br>
O objetivo do projeto é proporcionar uma manéira fácil para controlar as séries assistidas, detalhando o seus avanço a cada episódio.

É possível:

- Cadastrar e visualizar as séries que já assisti;
- Adicionar episódios a séries que já assistidas (indicando o número do episódio e o tempo em minutos que ele possui);
- Remover série com os seus episódios;
- Visualizar episódios assistidos de uma determinada séries;
- Visualizar tempo gasto total de todos os episódios já assistidos em todas as séries."

## :mag: Tecnologias utilizadas
- Construção da API - [Java](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) e
[Spring Boot](https://spring.io/projects/spring-boot)<br>
- Banco de dados [H2 Database Engine](h2database.com/html/main.html) <br>
 - Mapeamento de erros - [ControllerAdvice](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ControllerAdvice.html) <br>

## 📋 Execute o projeto em sua máquina

```
Clone o repositório:
git clone git@github.com:tamireshc/minhas-series.git
cd minhas-series

Instale as dependências:
mvn install

Rode o projeto
mvn spring-boot:run
```
## 🕵 Diagrama UML da API <br>

![Sem Título](https://github.com/tamireshc/minhas-series/assets/65035109/053cc172-1cc8-4240-97c3-be4fb063fe48)

## 🔎 Documentação da API

 :mega: Séries <br/>
  
 - Visualizar séries
```
GET api/series
```
Corpo da resposta:
  ```json
  [
      {
          "id": 1,
          "nome": "Doctor Who",
          "episodios": []
      },
      {
          "id": 2,
          "nome": "Friends",
          "episodios": []
      }
  ]
 ```

- Cadastro de série

```
  POST api/series
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` |   Nome da série. |

  Corpo da resposta:
  ```json
  {
      "id": 1,
      "nome": "Doctor Who",
      "episodios": []
  }
  ```

- Adicionar episódios

```
  POST api/series/:id/episodios
```
| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `numero` | `int` |   Número do episódio |
| `duracaoEmMinutos` | `int` |   duração em minutos do episódio |


  Corpo da resposta:
  ```json
  {
      "id": 1,
      "nome": "Doctor Who",
      "episodios": [
          {
              "id": 2,
              "numero": 1,
              "duracaoEmMinutos": 60
          }
      ]
  }
  ```

- Remover séries

```
  DELETE api/series/:id
```

- Visualizar episódios de uma série

```
GET api/series/:id/episodios
```
Corpo da resposta:
  ```json
  [
    {
      "id": 2,
      "numero": 1,
      "duracaoEmMinutos": 60
    }
  ]
  ```

- Visualizar tempo gasto

```
  GET api/series/tempo
```
Corpo da resposta:
  ```json
  {
    "tempoEmMinutos": 600
  }
  ```

#### Casos de Falha
- Cadastro de série com nome existente deve emitir a exceção `SerieExistenteException`
- Tentativas de acesso a uma série que não exista deve emitir a exceção `SerieNaoEncontradaException`
- Adição de episódios com o mesmo número para a mesma série deve emitir a exceção `EpisodioExistenteException`
- Casos de erro não mapeados neste documento devem emitir a exceção `ErroInesperadoException`
  
</details>




