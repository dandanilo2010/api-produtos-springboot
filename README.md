# API de Produtos - Spring Boot

Projeto de estudo desenvolvido com **Spring Boot** para criação de uma **API REST de gerenciamento de produtos e categorias**.

A aplicação permite realizar operações de **CRUD** em produtos e categorias, demonstrando conceitos importantes de desenvolvimento backend com Java.

---

# 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Maven
- Lombok
- H2 / MySQL
- REST API
- Git e GitHub

---

# 📦 Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

controller → recebe as requisições HTTP  
service → contém as regras de negócio  
repository → comunicação com banco de dados  
entity → representação das tabelas do banco  
dto → objetos usados para transferência de dados  
exception → tratamento global de erros  

---

# 📌 Funcionalidades

## Produtos

- Criar produto
- Listar produtos
- Buscar produto por ID
- Atualizar produto
- Deletar produto
- Buscar produtos por categoria

## Categorias

- Criar categoria
- Listar categorias
- Buscar categoria por ID
- Atualizar categoria
- Deletar categoria

---

# 🔗 Endpoints principais

## Produtos

Criar produto

POST /produtos

Exemplo de requisição:


{
"nome": "Mouse",
"preco": 50,
"quantidade": 10,
"categoria": {
"id": 1
}
}


Listar produtos

GET /produtos

Buscar produto por ID

GET /produtos/{id}

Buscar produtos por categoria

GET /produtos/categoria/{categoriaId}

---

## Categorias

Criar categoria

POST /categorias


{
"nome": "Informática"
}


Listar categorias

GET /categorias

Buscar categoria por ID

GET /categorias/{id}

---

# 🧠 Conceitos aplicados

Este projeto foi desenvolvido aplicando boas práticas de desenvolvimento backend:

- Arquitetura em camadas
- Uso de DTO para transferência de dados
- Relacionamento entre entidades (ManyToOne)
- Tratamento global de exceções
- Padrão REST para construção de APIs

---

# ▶️ Como executar o projeto

Clonar o repositório


git clone https://github.com/dandanilo2010/api-produtos-springboot.git


Entrar na pasta do projeto


cd api-produtos-springboot


Executar a aplicação


mvn spring-boot:run


A aplicação irá iniciar em:


http://localhost:8080


---

# 👨‍💻 Autor

**Danilo Augusto da Silva Araujo**

Desenvolvedor Full Stack
