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
    return e.equals(this.equipe);
  }

  public boolean getSexe(){
      return this.masculin;
  }
  
  public double getTemps(){
      return this.temps;
  }
} // Coureur