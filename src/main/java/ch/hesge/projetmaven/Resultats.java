package ch.hesge.projetmaven;

import ch.hesge.projetmaven.base.Fichier;
import ch.hesge.projetmaven.metier.ListeEquipes;
import ch.hesge.projetmaven.outils.FileToStr;

/**
 *
 * @author meckanik
 */
public class Resultats {

  public static void main(String[] args) {
    System.out.println("Traitement des résultats: ");
    
    FileToStr reader = new FileToStr();
    Fichier equipe = new Fichier(reader.read("Equipes.txt"));
    Fichier coureur = new Fichier(reader.read("Coureurs.txt"));
    
    ListeEquipes equipes = new ListeEquipes(equipe, coureur);

    if (equipes.isEmpty()) {
      System.out.println("Il n'y a point d'équipe");
    } else {
      equipes.afficherResultatsEquipe();
    }
  }
}
