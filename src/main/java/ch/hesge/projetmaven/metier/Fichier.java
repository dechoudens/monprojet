package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.outils.FileToStr;
import java.util.StringTokenizer;

/**
 * @author Antoine de Choudens
 */
public class Fichier {

  private String[] listeLigne;
  private int ligneCourante;
  private int listeSize;

  public Fichier(String data) {

    StringTokenizer strLigne = new StringTokenizer(data, "\n\r");
    listeSize = strLigne.countTokens();
    listeLigne = new String[listeSize];

    int i = 0;
    while (strLigne.hasMoreTokens()) {
      String uneLigne = strLigne.nextToken();
      listeLigne[i] = uneLigne;
      i++;
    }

    ligneCourante = 0;
  }

  public int size() {
    return listeLigne.length;
  }

  public boolean isLigneEquipe() {
    String ligne = listeLigne[ligneCourante];
    StringTokenizer strLigne = new StringTokenizer(ligne, ";");
    return strLigne.countTokens() == 2;
  }

  public String getLigneCourante() {
    return listeLigne[ligneCourante];
  }

  public boolean isNull() {
    return ligneCourante >= listeSize;
  }

  public void nextLigne() {
    ligneCourante++;
  }
}
