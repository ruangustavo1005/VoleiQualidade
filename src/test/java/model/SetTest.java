/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Ruan
 */
public class SetTest {
    
    
    @Test
    @DisplayName("Equipe 1 vence se atinge 25 pontos e a equipe 2 possue 20 pontos")
    public void testGetVencedor_ReturnEquipe1_WhenEquipe1Pontua25Equipe2Pontua20() {
        Equipe equipe1 = new Equipe("Equipe 1");
        Equipe equipe2 = new Equipe("Equipe 2");
        Partida partida = new Partida(equipe1, equipe2);
        partida.getSet(1).getEquipe1().setPontos(25);
        partida.getSet(1).getEquipe2().setPontos(20);
        Assertions.assertEquals(equipe1, partida.getSet(1).getVencedor().getEquipe());
    }
    
    @Test
    @DisplayName("Ninguém vence se a equipe 1 atinge 25 pontos e a equipe 2 possue 24 pontos")
    public void testGetVencedor_ReturnNull_WhenEquipe1Pontua25Equipe2Pontua24() {
        Equipe equipe1 = new Equipe("Equipe 1");
        Equipe equipe2 = new Equipe("Equipe 2");
        Partida partida = new Partida(equipe1, equipe2);
        partida.getSet(1).getEquipe1().setPontos(25);
        partida.getSet(1).getEquipe2().setPontos(24);
        Assertions.assertNull(partida.getSet(1).getVencedor());
    }
    
    @Test
    @DisplayName("Equipe 2 vence se atinge 27 pontos e a equipe 1 possue 25 pontos")
    public void testGetVencedor_ReturnEquipe2_WhenEquipe1Pontua25Equipe2Pontua27() {
        Equipe equipe1 = new Equipe("Equipe 1");
        Equipe equipe2 = new Equipe("Equipe 2");
        Partida partida = new Partida(equipe1, equipe2);
        partida.getSet(1).getEquipe1().setPontos(25);
        partida.getSet(1).getEquipe2().setPontos(27);
        Assertions.assertEquals(equipe2, partida.getSet(1).getVencedor().getEquipe());
    }
    
    
    public class SetImpl extends Set {

        @Override
        public int getMaxPontos() {
            return 25;
        }
        
        @Override
        public int getDiferencaPontosNecessaria() {
            return 2;
        }

    }
    
}
