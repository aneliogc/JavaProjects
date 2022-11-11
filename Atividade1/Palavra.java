package padrao;

public class Palavra {
    private String nome;
    private String traducao;

    public Palavra(String nome, String traducao) {
        this.nome = nome;
        this.traducao = traducao;
    }

    public String getNome() {
        return nome;
    }

    public String getTraducao() {
        return traducao;
    }

}
