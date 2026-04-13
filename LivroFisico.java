public class LivroFisico extends Livro {
    private int numeroExemplares;
    private String dimensoes;

    public LivroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas, int numeroExemplares,
            String dimensoes) {
        // this.setTitulo(titulo);
        // this.setAutor(autor);
        // this.setAnoPublicacao(anoPublicacao);
        // this.setNumeroPaginas(numeroPaginas);
        super(titulo, autor, anoPublicacao, numeroPaginas); // Invoca método construtor da super classe
        this.numeroExemplares = numeroExemplares;
        this.dimensoes = dimensoes;
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    @Override
    public String toString() {
        return super.toString() + " | Nº de Exemplares: " + this.numeroExemplares + " | Dimensões: " + this.dimensoes;
    }
}
