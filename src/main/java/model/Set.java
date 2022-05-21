package model;

abstract public class Set {

    private EquipeSet equipe1;
    private EquipeSet equipe2;

    abstract public int getMaxPontos();
    
    abstract public int getDiferencaPontosNecessaria();

    public Set() {

    }

    public Set(Equipe equipe1, Equipe equipe2) {
        this.equipe1 = new EquipeSet(equipe1);
        this.equipe2 = new EquipeSet(equipe2);
    }

    public EquipeSet getVencedor() {
        if (this.isVencedor(this.getEquipe1().getPontos(), this.getEquipe2().getPontos())) {
            return this.getEquipe1();
        }
        if (this.isVencedor(this.getEquipe2().getPontos(), this.getEquipe1().getPontos())) {
            return this.getEquipe2();
        }
        return null;
    }

    protected boolean isVencedor(int pontosEquipe, int pontosOutraEquipe) {
        return pontosEquipe >= this.getMaxPontos() && pontosEquipe >= pontosOutraEquipe + this.getDiferencaPontosNecessaria();
    }

    public EquipeSet getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(EquipeSet equipe1) {
        this.equipe1 = equipe1;
    }

    public EquipeSet getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(EquipeSet equipe2) {
        this.equipe2 = equipe2;
    }

}