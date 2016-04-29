package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.domaine.Equipe;
import java.util.StringTokenizer;

/**
 * @author Antoine de Choudens
 */
public class EquipeFactory {

  public Equipe creerEquipe(String ligne) {
    StringTokenizer strElem = new StringTokenizer(ligne, ";");
    String nomEquipe = strElem.nextToken();
    int nbCoureur = Integer.parseInt(strElem.nextToken());

    return new Equipe(nomEquipe, nbCoureur);
  }
}
