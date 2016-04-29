package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.domaine.Coureur;
import java.util.StringTokenizer;

/**
 * @author Antoine de Choudens
 */
public class CoureurFactory {

  public Coureur creerCoureur(String ligne) {
    StringTokenizer strElem = new StringTokenizer(ligne, ";");
    String nomCoureur = strElem.nextToken();
    String prenom = strElem.nextToken();
    char sexe = (strElem.nextToken()).charAt(0);
    double temps = Double.parseDouble(strElem.nextToken());

    return new Coureur(nomCoureur, prenom, sexe, temps);
  }
}
