package model;

public class Atleta {
	private int pontos;
    private String nome = "Atleta_";
    
    public Atleta() {
    }

    public Atleta(int id) {
        this.nome += id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos += pontos;
    }
}
