package ch.hesge.projetmaven.domaine;

import java.util.Objects;

/**
 * Tour du Canton de Genève
 *
 * Modélisation d'un coureur
 *
 * @author: Antoine de Choudens
 *
 */
public class Coureur {

  private final String nom;
  /* Nom du coureur */
  private final String prenom;
  /* Prénom du coureur */
  private final boolean masculin;
  /* true si le sexe est masculin ("M"), false si le sexe est féminin ("F") */
  private final double temps;
  /* Temps réalisé */
  private final String equipe;

  public Coureur(String nom, String prenom, char sexe, double temps, String equipe) {
    this.nom = nom;
    this.prenom = prenom;
    this.masculin = isMasculin(sexe);
    this.temps = temps;
    this.equipe = equipe;
  }

  private boolean isMasculin(char sexe) {
    return sexe == 'M';
  }

  @Override
  public String toString() {
    if (masculin) {
      return "meilleur = " + nom + " " + prenom + " (M) " + temps;
    } else {
      return "meilleur = " + nom + " " + prenom + " (F) " + temps;
    }
  }

  public boolean estMonEquipe(Equipe e) {
    return this.equipe.equals(e.getNom());
  }

  public boolean getSexe() {
    return this.masculin;
  }

  public double getTemps() {
    return this.temps;
  }

  @Override
  public boolean equals(Object o){
    double epsilon = 0.00000001;
    final Coureur other = (Coureur) o;
    if(other == null){
      return false;
    }
    if (this.masculin != other.masculin){
      return false;
    }
    if (Math.abs(this.temps - other.temps) >= epsilon) {
      return false;
    }
    if (!Objects.equals(this.nom, other.nom)) {
      return false;
    }
    if (!Objects.equals(this.prenom, other.prenom)) {
      return false;
    }
    return Objects.equals(this.equipe, other.equipe);
  }
  
} // Coureur
