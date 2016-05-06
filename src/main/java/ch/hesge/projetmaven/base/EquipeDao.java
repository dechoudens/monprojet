package ch.hesge.projetmaven.base;

import ch.hesge.projetmaven.domaine.Coureur;
import ch.hesge.projetmaven.domaine.Equipe;
import ch.hesge.projetmaven.outils.FileToStr;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Meckanik
 */
public class EquipeDao {

  private final String FICHIER_EQUIPE = "Equipes.txt";
  private final List<Equipe> listeEquipe;
  private final List<Coureur> listeCoureurs;
  private final CoureurDao coureurDao;

  public EquipeDao() {
    coureurDao = new CoureurDao();
    listeEquipe = new ArrayList<>();
    listeCoureurs = coureurDao.getListeCoureur();
  }

  public List getListeEquipe() {
    String data = FileToStr.read(FICHIER_EQUIPE);
    Fichier fichier = new Fichier(data);

    while (!fichier.isNull()) {
      String ligne = fichier.getLigneCourante();
      Equipe e = creerEquipe(ligne);

      ArrayList coureursEquipe = getCoureursEquipe(e);
      e.addCoureurs(coureursEquipe);

      listeEquipe.add(e);

      fichier.nextLigne();
    }

    return listeEquipe;
  }

  public Equipe creerEquipe(String ligne) {
    StringTokenizer strElem = new StringTokenizer(ligne, ";");
    String nomEquipe = strElem.nextToken();
    int nbCoureur = Integer.parseInt(strElem.nextToken());

    return new Equipe(nomEquipe, nbCoureur);
  }

  public ArrayList getCoureursEquipe(Equipe e) {
    ArrayList coureursEquipe = new ArrayList();
    for (Coureur coureur : listeCoureurs) {
      if (coureur.estMonEquipe(e)) {
        coureursEquipe.add(coureur);
      }
    }

    return coureursEquipe;
  }
}
