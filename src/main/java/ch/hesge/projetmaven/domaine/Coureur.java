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

  private String nom;       /* Nom du coureur */
  private String prenom;    /* Prénom du coureur */
  private boolean masculin; /* true si le sexe est masculin ("M"), false si le sexe est féminin ("F") */
  private double temps;     /* Temps réalisé */
  private String equipe;

  public Coureur(String nom, String prenom, char sexe, double temps, String equipe) {
    this.nom = nom;
    this.prenom = prenom;
    this.masculin = isMasculin(sexe);
    this.temps = temps;
    this.equipe = equipe;
  } 
  
  private boolean isMasculin(char sexe){
    return sexe == 'M';
  }

  public String toString () {
    if(masculin){
        return "meilleur = "+nom+" "+prenom+" (M) "+temps;
    }
    else{
        return "meilleur = "+nom+" "+prenom+" (F) "+temps;
    }
  }

  public boolean estMonEquipe(Equipe e) {
    return this.equipe.equals(e.getNom());
  }

  public boolean getSexe(){
      return this.masculin;
  }
  
  public double getTemps(){
      return this.temps;
  }

  @Override
  public boolean equals(Object obj) {

    final Coureur other = (Coureur) obj;
    if (this.masculin != other.masculin) {
      return false;
    }
    if (this.temps != other.temps) {
      return false;
    }
    if (!Objects.equals(this.nom, other.nom)) {
      return false;
    }
    if (!Objects.equals(this.prenom, other.prenom)) {
      return false;
    }
    if (!Objects.equals(this.equipe, other.equipe)) {
      return false;
    }
    return true;
  }
  
  
} // Coureur