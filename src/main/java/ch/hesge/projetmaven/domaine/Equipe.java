package ch.hesge.projetmaven.domaine;

import com.google.common.annotations.VisibleForTesting;
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

  private final String nom;
  private List<Coureur> coureurs;
  private int nbCoureur;

  public Equipe(String nom, int nbCoureur) {
    this.nom = nom;
    this.nbCoureur = nbCoureur;
    this.coureurs = new ArrayList<>();
  }
  
  public Equipe(String nom) {
    this.nom = nom;
  }

 public void addCoureurs(List coureurs) {
    this.coureurs = coureurs;
  }
 
  public String toString() {
    return "Equipe: " + this.composition() + " \"" + this.nom + "\", " + this.nbCoureur + " coureurs, " + this.meilleurCoureur();
  }

  public Coureur meilleurCoureur() {
    Coureur bestCoureur = coureurs.get(0);
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

    if (!Objects.equals(this.nom, ((Equipe)obj).nom)) {
      return false;
    }
    return true;
  }

  /**
   * utilisée uniquement pour les tests
   */
  @VisibleForTesting
  int getSizeListeCoureurs() {
    return coureurs.size();
  }

}
