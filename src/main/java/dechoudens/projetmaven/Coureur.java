package dechoudens.projetmaven;

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

  public Coureur (String nom, String prenom, char sexe, double temps) {
    this.nom = nom;
    this.prenom = prenom;
    this.masculin = isMasculin(sexe);
    this.temps = temps;
  } // Constructeur
  
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


  @Override
  public boolean equals(Object obj) {
   
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Coureur other = (Coureur) obj;
    if (this.masculin != other.masculin) {
      return false;
    }
    if (Double.doubleToLongBits(this.temps) != Double.doubleToLongBits(other.temps)) {
      return false;
    }
    if (!Objects.equals(this.nom, other.nom)) {
      return false;
    }
    if (!Objects.equals(this.prenom, other.prenom)) {
      return false;
    }
    return true;
  }
  
  
  
  public boolean getSexe(){
      return this.masculin;
  }
  
  public double getTemps(){
      return this.temps;
  }
} // Coureur