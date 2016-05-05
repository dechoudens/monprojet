package ch.hesge.projetmaven;

import ch.hesge.projetmaven.metier.ListeEquipes;

/**
 *
 * @author meckanik
 */
public class Resultats {

  public static void main(String[] args) {
    System.out.println("Traitement des résultats: ");

    ListeEquipes equipes = new ListeEquipes();

    if (equipes.isEmpty()) {
      System.out.println("Il n'y a point d'équipe");
    } else {
      equipes.afficherResultatsEquipe();
    }
  }
}
