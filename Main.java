import java.util.List;

//Dependencias
LivroService service = new LivroService();

void main() {
    String menu = """
            ===== SysBiblio =====
            1 - Cadastrar livro
            2 - Listar livros
            3 - Pesquisar livro
            4 - Remover livro
            5 - Editar livro
            0 - Sair
            """;
    int opcao;

    do {
        IO.println(menu);
        opcao = Input.scanInt("Digite uma opção: ");
        try {
            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> pesquisar();
                case 4 -> remover();
                case 5 -> editar();
                case 0 -> IO.println("Até breve!");
                default -> IO.println("Opção inválida!");

            }
        } catch (Exception e) {
            IO.println("ERRO: " + e.getMessage());
        }

        IO.readln("Pressione Enter para continuar...");

    } while (opcao != 0);
}

void cadastrar() throws Exception {
    String titulo = Input.scanString("Digite o título do livro: ");
    String autor = Input.scanString("Digite o autor do livro: ");
    int anoPublicacao = Input.scanInt("Digite o ano de publicação do livro: ");
    int numeroPaginas = Input.scanInt("Digite o número de páginas do livro: ");

    int tipoLivro = Input.scanInt( "Qual o tipo do livro? (1) Físico; (2) Digital: ");
    Livro novoLivro;
        if (tipoLivro == 1) {
            int numeroExemplares = Input.scanInt("Digite o número de exemplares: ");
            String dimensoes = Input.scanString("Digite as dimensões: ");

            novoLivro = new LivroFisico(titulo, autor, anoPublicacao, numeroPaginas, numeroExemplares, dimensoes);
        
        } else if (tipoLivro == 2) {
            Double tamanhoArquivo = Input.scanDouble("Digite o tamanho do arquivo (MB): ");
            String formatoArquivo = Input.scanString("Digite o formato do arquivo: ");
            novoLivro = new LivroDigital(titulo, autor, anoPublicacao, numeroPaginas, tamanhoArquivo, formatoArquivo);
        } else
            throw new Exception ("Tipo de livro inválido!");

    service.cadastrar(novoLivro);

    IO.println("Livro cadastrado com sucesso!");
}

void listar() {

    List<Livro> livros = service.listar();

    imprimirLista(livros);

}

void pesquisar() throws Exception {
    
    String menuPesquisa = """
            1 - Pesquisar por título
            2 - Pesquisar por autor
            3 - Pesquisar por ano de publicação
            """;

    IO.println(menuPesquisa);
    int opcao = Input.scanInt("Escolha uma opção: ");

    List<Livro> livros;

    switch (opcao) {
        case 1 -> {
            String pesquisa = Input.scanString("Digite parte do título: ");
            livros = service.pesquisar(pesquisa);
            imprimirLista(livros);
        }
        case 2 -> {
            String autor = Input.scanString("Digite parte do autor: ");
            livros = service.pesquisarPorAutor(autor);
            imprimirLista(livros);
        }
        case 3 -> {
            int ano = Input.scanInt("Digite o ano de publicação: ");
            livros = service.pesquisarPorAnoPublicacao(ano);
            imprimirLista(livros);
        }
        default -> IO.println("Opção inválida!");
    }
}

void imprimirLista(List<Livro> livros) {
    if (livros.isEmpty()) {
        IO.println("Nenhum livro cadastrado!");
        return;
    }
    int i = 1;
    for (Livro livro : livros) {
        IO.println(i++  + " - " + livro);
    }
}

void remover() throws Exception {
    List<Livro> livros = service.listar();

    imprimirLista(livros);

    if (livros.isEmpty())
        return;

    int numero = Input.scanInt("Digite o número do livro que deseja remover: ");

    service.remover(numero - 1);

    IO.println("Livro removido com sucesso!");
}

void editar() throws Exception {
    List<Livro> livros = service.listar();

    imprimirLista(livros);

    if (livros.isEmpty())
        return;

    int numero = Input.scanInt("Digite o número do livro que deseja editar: ");

    String titulo = Input.scanString("Digite o novo título do livro: ");
    String autor = Input.scanString("Digite o novo autor do livro: ");
    int anoPublicacao = Input.scanInt("Digite o novo ano de publicação do livro: ");
    int numeroPaginas = Input.scanInt("Digite o novo número de páginas do livro: ");

    Livro livroEditado = new Livro(titulo, autor, anoPublicacao, numeroPaginas);

    service.editar(numero - 1, livroEditado);

    IO.println("Livro editado com sucesso!");
}
