package ch.hesge.projetmaven;

import ch.hesge.projetmaven.domaine.Equipe;
import ch.hesge.projetmaven.domaine.Coureur;
import ch.hesge.projetmaven.metier.CoureurFactory;
import ch.hesge.projetmaven.metier.EquipeFactory;
import ch.hesge.projetmaven.metier.Fichier;
import ch.hesge.projetmaven.metier.ListeEquipe;
import ch.hesge.projetmaven.outils.FileToStr;
import java.util.*;

/**
 * Tour du Canton de Genève
 *
 * @author: Antoine de Choudens
 *
 */
public class Resultats {

  private final CoureurFactory coureurFactory;
  private final EquipeFactory equipeFactory;
  private final ListeEquipe listeEquipe;
  private Fichier fichier;

  public Resultats() {
    coureurFactory = new CoureurFactory();
    equipeFactory = new EquipeFactory();
    listeEquipe = new ListeEquipe();
  }

  public void traiterFichier(String fileName) {
    String data = FileToStr.read(fileName);
    
    fichier = new Fichier(data);

    while (!fichier.isNull()) {
      String ligne = fichier.getLigneCourante();
      if (fichier.isLigneEquipe()) {
        creerEquipe(ligne);
      } else {
        creerCoureur(ligne);
      }
      fichier.nextLigne();
    }
  }

  public void creerCoureur(String strLigne) {
    Coureur c = coureurFactory.creerCoureur(strLigne);
    listeEquipe.ajouterCoureurDerniereEquipe(c);
  }

  public void creerEquipe(String strLigne) {
    Equipe e = equipeFactory.creerEquipe(strLigne);
    listeEquipe.add(e);
  }

  public void afficheResultats() {
    if (listeEquipe.size() < 1) {
      System.out.println("Il n'y a point d'équipe");
    } else {
      listeEquipe.afficherEquipe();
    }
  }
}
