package dechoudens.projetmaven;

import java.util.*;

/**
 * Tour du Canton de Genève
 *
 * Modélisation d'une équipe
 *
 * @author: Antoine de Choudens
 *
 */
public class Equipe {

  private String nom;
  /* Nom de l'équipe */
  private ArrayList coureurs;
  /* Liste des coureurs de l'équipe */
  private int nbCoureur;

  public Equipe(String nom, int nbCoureur) {
    this.nom = nom;
    this.nbCoureur = nbCoureur;
    this.coureurs = new ArrayList();
  }

  /**
   * Ajoute le Coureur c à la liste des coureurs de l'équipe
   */
  public void addCoureur(Coureur c) {
    this.coureurs.add(c);
  }

  /**
   * Retourne une représentation des informations de l'équipe sous la forme d'un
   * String
   */
  public String toString() {
    return "Equipe: " + this.majorite() + " \"" + this.nom + "\", " + this.nbCoureur + " coureurs, " + this.meilleur();
  }

  public Coureur meilleur() {
    Coureur bestCoureur = (Coureur) coureurs.get(0);
    for (int i = 0; i <= coureurs.size() - 1; i++) {
      Coureur coureur = (Coureur) coureurs.get(i);
      if (coureur.getTemps() < bestCoureur.getTemps()) {
        bestCoureur = (Coureur) coureurs.get(i);
      }
    }
    return bestCoureur;
  }

  public String majorite() {
    int nbMasc = 0;
    for (int i = 0; i < coureurs.size(); i++) {
      Coureur coureur = (Coureur) coureurs.get(i);
      if (coureur.getSexe()) {
        nbMasc++;
      }
    }
    if (nbMasc == nbCoureur) {
      return "masculine";
    } else if (nbMasc == 0) {
      return "feminine";
    } else {
      return "mixte";
    }
  }

}
