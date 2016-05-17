package ch.hesge.projetmaven;

import ch.hesge.projetmaven.base.EquipeDao;
import ch.hesge.projetmaven.base.Fichier;
import ch.hesge.projetmaven.metier.ListeEquipes;
import ch.hesge.projetmaven.outils.FileToStr;
import java.io.File;
import java.nio.file.Files;

/**
 *
 * @author meckanik
 */
public class Resultats {

  public static void main(String[] args) {
    System.out.println("Traitement des résultats: ");
   
    FileToStr reader = new FileToStr();
    //String url=this.getClass().getResource("/Coureurs.txt").getPath();
    Fichier equipe = new Fichier(reader.read("Equipes.txt"));
    Fichier coureur = new Fichier(reader.read("Coureurs.txt"));
    
    EquipeDao equipeDao = new EquipeDao(equipe, coureur);
    ListeEquipes equipes = new ListeEquipes(equipeDao);

    if (equipes.isEmpty()) {
      System.out.println("Il n'y a point d'équipe");
    } else {
      equipes.afficherResultatsEquipe();
    }
  }
  
}
