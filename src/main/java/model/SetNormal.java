package model;

public class SetNormal extends Set {

    public SetNormal(Equipe equipe1, Equipe equipe2) {
        super(equipe1, equipe2);
    }

    @Override
    public int getMaxPontos() {
        return 25;
    }

}