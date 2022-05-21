package model;

import java.util.HashMap;

public class Partida {

    private HashMap<Integer, Set> sets;

    public Partida(Equipe equipe1, Equipe equipe2) {
        this.sets = new HashMap<>();
        this.sets.put(1, new SetNormal(equipe1, equipe2));
        this.sets.put(2, new SetNormal(equipe1, equipe2));
        this.sets.put(3, new SetNormal(equipe1, equipe2));
        this.sets.put(4, new SetNormal(equipe1, equipe2));
        this.sets.put(5, new SetFinal(equipe1, equipe2));
    }

    public Equipe getVencedor() {
        if (this.getSet(3).getVencedor() == null) {
            // Se o terceiro set ainda não acabou, não tem por que rodar a lógica
            // "O jogo termina quando um time vence três sets"
            return null;
        }

        HashMap<String, Integer> setsVencidosEquipe = new HashMap<>();
        Equipe equipeVencedora = null;
        for (int numeroSet : this.getSets().keySet()) {
            Set set = this.getSet(numeroSet);

            EquipeSet equipeVencedoraSet = set.getVencedor();
            if (equipeVencedoraSet != null) {
                String nomeEquipeVencedora = equipeVencedoraSet.getEquipe().getNome();

                if (setsVencidosEquipe.containsKey(nomeEquipeVencedora)) {
                    int setsVencidosEquipeVencedoraSet = setsVencidosEquipe.get(nomeEquipeVencedora) + 1;

                    if (setsVencidosEquipeVencedoraSet == 3) {
                        equipeVencedora = equipeVencedoraSet.getEquipe();
                        break;
                    }

                    setsVencidosEquipe.put(nomeEquipeVencedora, setsVencidosEquipeVencedoraSet);
                }
                else {
                    setsVencidosEquipe.put(nomeEquipeVencedora, 1);
                }
            }
        }
        return equipeVencedora;
    }

    public int getSetsVencidosByEquipe(Equipe equipe) {
        int setsVencidos = 0;
        for (int numeroSet : this.getSets().keySet()) {
            EquipeSet equipeVencedoraSet = this.getSet(numeroSet).getVencedor();
            if (equipeVencedoraSet == null) {
                break;
            }
            if (equipeVencedoraSet.getEquipe().getNome().equals(equipe.getNome())) {
                setsVencidos++;
            }
        }
        return setsVencidos;
    }

    public int getIndexSetAtual () {
        for (int i = 1; i <= 4; i ++) {
            Set set = this.getSet(i);
            if (set.getVencedor() == null) {
                return i;
            }
        }
        return 5;
    }

    public HashMap<Integer, Set> getSets() {
        return sets;
    }

    public Set getSet(int numeroSet) {
        return this.sets.get(numeroSet);
    }
}
