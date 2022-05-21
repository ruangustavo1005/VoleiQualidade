package model;

public class SetFinal extends Set {

    public SetFinal(Equipe equipe1, Equipe equipe2) {
        super(equipe1, equipe2);
    }

    @Override
    public int getMaxPontos() {
        return 15;
    }

}