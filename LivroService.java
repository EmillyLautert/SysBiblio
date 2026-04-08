import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LivroService {

    private List<Livro> acervo = new ArrayList<>();

    public void cadastrar(Livro novoLivro) throws Exception {
        if (novoLivro == null)
            throw new Exception("Objeto nulo!");
        
        //validar título
        if (novoLivro.getTitulo() == null || novoLivro.getTitulo().isEmpty())
            throw new Exception("Título inválido!");

        // formatar título todo para caixa alta
        novoLivro.setTitulo(novoLivro.getTitulo().trim().toUpperCase());

        //validar autor
        if (novoLivro.getAutor() == null || novoLivro.getAutor().isEmpty())
            throw new Exception("Autor inválido!");

        // formatar autor todo para caixa alta
        novoLivro.setAutor(novoLivro.getAutor().trim().toUpperCase());

        if (novoLivro.getAnoPublicacao() < 1900
                || novoLivro.getAnoPublicacao() > LocalDate.now().getYear())
            throw new Exception("Ano de publicação inválido!");
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(novoLivro.getTitulo())
                    && livro.getAutor().equalsIgnoreCase(novoLivro.getAutor())
                    && livro.getAnoPublicacao() == novoLivro.getAnoPublicacao())
                throw new Exception("Já existe livro cadastrado com este título, autor e ano de publicação!");
        }

//Nesta parte estaria chamando a camada Repository - salvar em banco de dados - não serão feitos repositórios

        acervo.add(novoLivro);
    }

    public List<Livro> listar() {
        return acervo;
    }

    public List<Livro> pesquisar(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        titulo = titulo.toUpperCase();
        
        for (Livro livro : acervo) {
            if (livro.getTitulo().contains(titulo))
                livrosEncontrados.add(livro);
        }
        return livrosEncontrados;
    }
}
//String é um objeto (inicia em letra maiúscula) e int (iniciado em minúscula) é dado primitivo