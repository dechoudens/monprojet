package ch.hesge.projetmaven.base;

import ch.hesge.projetmaven.domaine.Coureur;
import ch.hesge.projetmaven.domaine.Equipe;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Meckanik
 */
public class EquipeDao {

  private final List<Equipe> listeEquipe = new ArrayList<>();
  private final List<Coureur> listeCoureurs;
  private final CoureurDao coureurDao;
  private final Fichier fichier;
  
  public EquipeDao(Fichier equipe, Fichier coureur) {
    this.coureurDao = new CoureurDao(coureur);
    this.listeCoureurs = coureurDao.getListeCoureur();
    this.fichier = equipe;
  }

  public List getListeEquipe() {

    while (!fichier.isEOF()) {
      String ligne = fichier.getLigneCourante();
      Equipe e = creerEquipe(ligne);

      ArrayList coureursEquipe = getCoureursEquipe(e);
      e.addCoureurs(coureursEquipe);
      
      listeEquipe.add(e);
      fichier.nextLigne();
    }

    return listeEquipe;
  }

  private Equipe creerEquipe(String ligne) {
    StringTokenizer strElem = new StringTokenizer(ligne, ";");
    String nomEquipe = strElem.nextToken();
    int nbCoureur = Integer.parseInt(strElem.nextToken());

    return new Equipe(nomEquipe, nbCoureur);
  }

  private ArrayList getCoureursEquipe(Equipe e) {
    ArrayList coureursEquipe = new ArrayList();
    for (Coureur coureur : listeCoureurs) {
      if (coureur.estMonEquipe(e)) {
        coureursEquipe.add(coureur);
      }
    }

    return coureursEquipe;
  }
}
