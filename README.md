# Spring boot programacao reativa ![badge](https://img.shields.io/github/languages/top/willyoliv/spring_boot_programacao_reativa)
Um pequeno projeto feito em Spring boot, é um pequeno CRUD de usuários usando Mongodb via Docker. Este projeto utiliza a abordagem de programação reativa.

## Rodando o projeto
O projeto foi criado utilizando o `Maven` como gerenciador de dependências. Será necessário o uso do `Docker`. Também será necessário utilizar alguma IDE para visualizar o código como por exemplo: Intellij (utilizada), Netbeans, Eclipse ou qualquer um editor de sua preferência. 

```bash
# Clone este repositório
$ git clone https://github.com/willyoliv/spring_boot_programacao_reativa.git

# Acesse a pasta do projeto no terminal/cmd
$ cd spring_boot_programacao_reativa

# Criar os containers docker
$ docker-compose up

```

## Endpoints
O projeto vai por padrão executar em `http://localhost:8080/`, ele possuí dois controller que fazem as mesmas operações de CRUD porém usando abordagens diferentes.

### Create 
Para adicionar um usuário é necessário informar os campos id, nome, email, telefone, empresa. Abaixo é apresentado um modelo de body para a requisição.

Método **POST** localhost:8080/v1/usuarios ou localhost:8080/v2/usuarios

```
{
   "id": "1234567",
   "nome": "Nome do usuário",
   "email": "email@email.com",
   "telefone": "1234-1234",
   "empresa": "Nome da empresa"
}

```

### Read
Para obter a lista completa do usuários.

Método **GET** localhost:8080/v1/usuarios ou localhost:8080/v2/usuarios

### Read by ID
Para obter um usuário específico basta passar o `id` do usuário pela url.

Método **GET** localhost:8080/v1/usuarios/`id` ou localhost:8080/v2/usuarios/`id`

### Update 
Para atualizar os dados de um usuário basta passar o `id` do usuário pela url e um body com os campos id, nome, email, telefone, empresa. Abaixo é apresentado um modelo de body para a requisição.

Método **PUT** localhost:8080/v1/usuarios/`id` ou localhost:8080/v2/usuarios/`id`

```
{
   "id": "1234567",
   "nome": "Nome do usuário",
   "email": "email@email.com",
   "telefone": "1234-1234",
   "empresa": "Nome da empresa"
}

```

### Delete
Para deletar um usuário específico basta passar o `id` do usuário pela url.

Método **DELETE** localhost:8080/v1/usuarios/`id` ou localhost:8080/v2/usuarios/`id`

