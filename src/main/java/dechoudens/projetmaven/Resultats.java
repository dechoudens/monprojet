package dechoudens.projetmaven;

import java.util.*;

/**
 * Tour du Canton de Genève
 *
 * @author: Antoine de Choudens
 *
 */
public class Resultats {

  private ArrayList<Equipe> equipes = new ArrayList();

  /* Liste des équipes participant à la course */

 /* Stocke str (contenant tout le fichier de données) dans l'ArrayList equipes.
		- Le String str est découpé en lignes avec un StringTokenizer; les séparateurs de ligne sont "\n\r".
		- Les lignes contiennent 
			- soit les données d'une équipe (nom;nombre de coureurs)
			- soit les données d'un coureur (nom;prénom;sexe;temps)	(le sexe est soit "M", soit "F") */
  public void stockerResultats(String str) {
    StringTokenizer strLigne = new StringTokenizer(str, "\n\r");
    while (strLigne.hasMoreTokens()) {
      String uneLigne = strLigne.nextToken();
      traiterUneLigne(uneLigne);
    }

  }

  public void traiterUneLigne(String uneLigne) {
    StringTokenizer strLigne = new StringTokenizer(uneLigne, ";");
    switch (strLigne.countTokens()) {
      case 2:
        creerEquipe(uneLigne);
        break;
      case 4:
        creerCoureur(uneLigne);
        break;
    }
  }

  public void creerCoureur(String strLigne) {
    StringTokenizer strElem = new StringTokenizer(strLigne, ";");
    String nomCoureur = strElem.nextToken();
    String prenom = strElem.nextToken();
    char sexe = (strElem.nextToken()).charAt(0);
    double temps = Double.parseDouble(strElem.nextToken());
    Coureur c = new Coureur(nomCoureur, prenom, sexe, temps);

    int derniereEquipe = equipes.size() - 1;
    Equipe equipe = equipes.get(derniereEquipe);
    equipe.addCoureur(c);
  }

  public void creerEquipe(String strLigne) {
    StringTokenizer strElem = new StringTokenizer(strLigne, ";");
    String nomEquipe = strElem.nextToken();
    int nbCoureur = Integer.parseInt(strElem.nextToken());
    Equipe e = new Equipe(nomEquipe, nbCoureur);
    equipes.add(e);
  }

  public void afficheResultats(String fileName) {
    stockerResultats(FileToStr.read(fileName));

    if (equipes.size() < 1) {
      System.out.println("Il n'y a point d'équipe, t'entends !!! test conflict!");
    } else {
      Iterator it = equipes.iterator();
      while (it.hasNext()) {
        System.out.println(it.next());
      }
    }
  }
}
