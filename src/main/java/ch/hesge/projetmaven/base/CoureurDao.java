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
  
  private final List<Coureur> liste;
  private Fichier fichier;

  public CoureurDao(Fichier fichier) {
    this.liste = new ArrayList<>();
    this.fichier = fichier;
  }
  
  public List getListeCoureur() {

    while (!fichier.isNull()) {
      String ligne = fichier.getLigneCourante();
      Coureur c = creerCoureur(ligne);
      liste.add(c);
      fichier.nextLigne();
    }

    return liste;
  }

  private Coureur creerCoureur(String ligne) {
    StringTokenizer strElem = new StringTokenizer(ligne, ";");
    String nomCoureur = strElem.nextToken();
    String prenom = strElem.nextToken();
    char sexe = (strElem.nextToken()).charAt(0);
    double temps = Double.parseDouble(strElem.nextToken());
    String equipe = strElem.nextToken();

    return new Coureur(nomCoureur, prenom, sexe, temps, equipe);
  }
}
