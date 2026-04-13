# 📚 Atividade – Evolução do Sistema SysBiblio

**Aluna:** Emilly Lautert dos Santos  
**RA:** 1138184  

---
## 📖 Contexto da Atividade

Nas aulas da disciplina de Organização e Abstração da Programação, foi desenvolvido inicialmente o sistema SysBiblio. Na sequência, como atividade, este sistema foi refatorado e evoluído, com a implementação de novas funcionalidades e melhorias, respeitando a separação em camadas apresentada em aula.

## 🖥️ Funcionamento do Sistema

O **SysBiblio** é um sistema simples de gerenciamento de biblioteca desenvolvido em Java para execução em terminal.

O sistema permite ao usuário realizar operações básicas sobre um acervo de livros, incluindo cadastro, listagem, pesquisa, edição e remoção.

Este sistema segue o modelo de separação de responsabilidades:

- Main.java → Responsável pela interação com o usuário (menu, leitura de dados e exibição);
- LivroService.java → Responsável pelas regras de negócio e manipulação dos dados;
- Livro.java → Representa a entidade Livro;
- Input.java → Auxilia na leitura e validação de dados de entrada;

### 🔹 Menu principal

O usuário interage com o sistema através de um menu com as seguintes opções:

- 1 - Cadastrar livro  
- 2 - Listar livros  
- 3 - Pesquisar livro  
- 4 - Remover livro  
- 5 - Editar livro  
- 0 - Sair  

### 🔹 Funcionalidades

- **Cadastro de livro:** permite inserir título, autor, ano de publicação e número de páginas;
- **Listagem:** exibe todos os livros cadastrados com título, autor, ano de publicação e número de páginas;
- **Pesquisa:** permite buscar livros por título, autor ou ano de publicação;
- **Remoção:** exclui um livro com base no índice da lista;
- **Edição:** permite alterar os dados de um livro existente;

O sistema utiliza uma lista em memória para armazenar os dados, sem uso de banco de dados.

## ✅ Melhorias obrigatórias implementadas

Foram implementadas as seguintes melhorias exigidas na atividade:

- ✔️ Remoção de livro por índice  
- ✔️ Edição dos dados de um livro  
- ✔️ Pesquisa por:
  - título
  - autor
  - ano de publicação

## ⭐ Melhoria livre implementada

Além dos requisitos obrigatórios, foram implementadas melhorias adicionais relacionadas à validação de dados:

### 🔹 Validação do número de páginas
- Impede o cadastro ou edição de livros com:
  - número de páginas igual a 0  
  - número de páginas negativo  

### 🔹 Validação na pesquisa
- Impede pesquisas com:
  - valores `null`  
  - textos vazios  
  - entradas contendo apenas espaços  

Essas validações tornam o sistema mais robusto e evitam inconsistências nos dados.