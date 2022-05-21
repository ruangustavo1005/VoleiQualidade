package model;

public class EquipeSet {

    private Equipe equipe;
    private int pontos = 0;

    public EquipeSet(Equipe equipe) {
        this.equipe = equipe;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public int getPontos() {
        return pontos;
    }

    public String getPontosAsString() {
        return this.getPontos() < 10 ? ("0" + this.getPontos()) : String.valueOf(this.getPontos());
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void addPonto() {
        this.pontos++;
    }
}
