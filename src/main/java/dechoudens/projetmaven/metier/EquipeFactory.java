package dechoudens.projetmaven.metier;

import dechoudens.projetmaven.domaine.Equipe;
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
