package ch.hesge.projetmaven.base;

import ch.hesge.projetmaven.domaine.Coureur;
import ch.hesge.projetmaven.outils.FileToStr;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Meckanik
 */
public class CoureurDao {

  private final String FICHIER_COUREUR = "Coureurs.txt";
  private final List<Coureur> liste;

  public CoureurDao() {
    liste = new ArrayList<>();
  }

  public List getListeCoureur() {
    String data = FileToStr.read(FICHIER_COUREUR);
    Fichier fichier = new Fichier(data);

    while (!fichier.isNull()) {
      String ligne = fichier.getLigneCourante();
      Coureur c = creerCoureur(ligne);
      liste.add(c);
      fichier.nextLigne();
    }

    return liste;
  }

  public Coureur creerCoureur(String ligne) {
    StringTokenizer strElem = new StringTokenizer(ligne, ";");
    String nomCoureur = strElem.nextToken();
    String prenom = strElem.nextToken();
    char sexe = (strElem.nextToken()).charAt(0);
    double temps = Double.parseDouble(strElem.nextToken());
    String equipe = strElem.nextToken();

    return new Coureur(nomCoureur, prenom, sexe, temps, equipe);
  }
}
