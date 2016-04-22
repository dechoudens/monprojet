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
  private ArrayList<Coureur> coureurs;
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
    return "Equipe: " + this.composition() + " \"" + this.nom + "\", " + this.nbCoureur + " coureurs, " + this.meilleurCoureur();
  }

  public Coureur meilleurCoureur() {
    Coureur bestCoureur = (Coureur) coureurs.get(0);
    for (Coureur coureur : coureurs) {
      if (coureur.getTemps() < bestCoureur.getTemps()) {
        bestCoureur = coureur;
      }
    }
    return bestCoureur;
  }

  private int nombreMasculin(){
    int nbMasc = 0;
    for (Coureur coureur : coureurs) {
      if (coureur.getSexe()) {
        nbMasc++;
      }
    }
    return nbMasc;
  }
  
  public String composition(){  
    int nbMasc = nombreMasculin();
    
    if (nbMasc == nbCoureur) {
      return "masculine";
    } else if (nbMasc == 0) {
      return "feminine";
    } else {
      return "mixte";
    }
  }

  @Override
  public boolean equals(Object obj) {

    final Equipe other = (Equipe) obj;
    if (!Objects.equals(this.nom, other.nom)) {
      return false;
    }
    return true;
  }

  /**
   * utilisée uniquement pour les tests
   */
  public int getSizeListeCoureurs() {
    return coureurs.size();
  }

  /**
   * utilisée uniquement pour les tests
   */
  public void setCoureurs(ArrayList coureurs) {
    this.coureurs = coureurs;
  }

  /**
   * utilisée uniquement pour les tests
   */
  public ArrayList getCoureurs() {
    return coureurs;
  }

}
