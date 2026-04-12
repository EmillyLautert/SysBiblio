
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LivroService {

    private List<Livro> acervo = new ArrayList<>();

    public void cadastrar(Livro novoLivro) throws Exception {
        if (novoLivro == null) {
            throw new Exception("Objeto nulo!");
        }

        //validar título
        if (novoLivro.getTitulo() == null || novoLivro.getTitulo().isEmpty()) {
            throw new Exception("Título inválido!");
        }

        // formatar título todo para caixa alta
        novoLivro.setTitulo(novoLivro.getTitulo().trim().toUpperCase());

        //validar autor
        if (novoLivro.getAutor() == null || novoLivro.getAutor().isEmpty()) {
            throw new Exception("Autor inválido!");
        }

        // formatar autor todo para caixa alta
        novoLivro.setAutor(novoLivro.getAutor().trim().toUpperCase());

        if (novoLivro.getAnoPublicacao() < 1900
                || novoLivro.getAnoPublicacao() > LocalDate.now().getYear()) {
            throw new Exception("Ano de publicação inválido!");
        }

        // validar número de páginas
        if (novoLivro.getNumeroPaginas() <= 0) {
            throw new Exception("Número de páginas inválido! Deve ser maior que zero.");
        }

        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(novoLivro.getTitulo())
                    && livro.getAutor().equalsIgnoreCase(novoLivro.getAutor())
                    && livro.getAnoPublicacao() == novoLivro.getAnoPublicacao()) {
                throw new Exception("Já existe livro cadastrado com este título, autor e ano de publicação!");
            }
        }
//Nesta parte estaria chamando a camada Repository - salvar em banco de dados - não serão feitos repositórios
        acervo.add(novoLivro);
    }

    public List<Livro> listar() {
        return acervo;
    }

    public List<Livro> pesquisar(String titulo) throws Exception {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new Exception("Título inválido para pesquisa!");
        }

        List<Livro> livrosEncontrados = new ArrayList<>();
        titulo = titulo.toUpperCase();

        for (Livro livro : acervo) {
            if (livro.getTitulo().contains(titulo)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisarPorAutor(String autor) throws Exception {
        if (autor == null || autor.trim().isEmpty()) {
            throw new Exception("Autor inválido para pesquisa!");
        }

        List<Livro> livrosEncontrados = new ArrayList<>();
        autor = autor.toUpperCase();

        for (Livro livro : acervo) {
            if (livro.getAutor().contains(autor)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisarPorAnoPublicacao(int anoPublicacao) {
        List<Livro> livrosEncontrados = new ArrayList<>();

        for (Livro livro : acervo) {
            if (livro.getAnoPublicacao() == anoPublicacao) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public void remover(int indice) throws Exception {
        if (indice < 0 || indice >= acervo.size()) {
            throw new Exception("Livro não encontrado!");
        }

        acervo.remove(indice);
    }

    public void editar(int indice, Livro livroEditado) throws Exception {
        if (indice < 0 || indice >= acervo.size()) {
            throw new Exception("Livro inválido para edição!");
        }

        if (livroEditado == null) {
            throw new Exception("Objeto nulo!");
        }

        if (livroEditado.getTitulo() == null || livroEditado.getTitulo().isEmpty()) {
            throw new Exception("Título inválido!");
        }

        livroEditado.setTitulo(livroEditado.getTitulo().trim().toUpperCase());

        if (livroEditado.getAutor() == null || livroEditado.getAutor().isEmpty()) {
            throw new Exception("Autor inválido!");
        }

        livroEditado.setAutor(livroEditado.getAutor().trim().toUpperCase());

        if (livroEditado.getAnoPublicacao() < 1900
                || livroEditado.getAnoPublicacao() > LocalDate.now().getYear()) {
            throw new Exception("Ano de publicação inválido!");
        }

        if (livroEditado.getNumeroPaginas() <= 0) {
            throw new Exception("Número de páginas inválido! Deve ser maior que zero.");
        }

        for (int i = 0; i < acervo.size(); i++) {
            if (i != indice) {
                Livro livro = acervo.get(i);
                if (livro.getTitulo().equalsIgnoreCase(livroEditado.getTitulo())
                        && livro.getAutor().equalsIgnoreCase(livroEditado.getAutor())
                        && livro.getAnoPublicacao() == livroEditado.getAnoPublicacao()) {
                    throw new Exception("Já existe livro cadastrado com este título, autor e ano de publicação!");
                }
            }
        }

        acervo.set(indice, livroEditado);
    }
}
//String é um objeto (inicia em letra maiúscula) e int (iniciado em minúscula) é dado primitivo
