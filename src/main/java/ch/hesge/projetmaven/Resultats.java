package ch.hesge.projetmaven;

import ch.hesge.projetmaven.base.EquipeDao;
import ch.hesge.projetmaven.base.Fichier;
import ch.hesge.projetmaven.metier.ListeEquipes;
import ch.hesge.projetmaven.outils.FileToStr;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author meckanik
 */
public class Resultats {
  
  public Resultats(String[] args) throws Exception{
    System.out.println("Traitement des résultats: ");

    if (checkArgs(args)) {
      
      //List<String> fichierEquipe = Files.readAllLines(Paths.get(args[0]), Charset.defaultCharset());
      //List<String> fichierCoureur = Files.readAllLines(Paths.get(args[1]), Charset.defaultCharset());
      
      File fileEquipe = new File(args[0]);
      File fileCoureur = new File(args[1]);

      
      FileToStr readFile = new FileToStr();
      Fichier equipe = new Fichier(readFile.read(fileEquipe));
      Fichier coureur = new Fichier(readFile.read(fileCoureur));
      
      EquipeDao equipeDao = new EquipeDao(equipe, coureur);
      ListeEquipes equipes = new ListeEquipes(equipeDao);

      if (!equipes.isEmpty()) {
        equipes.afficherResultatsEquipe();
      } else {
        throw new Exception("Il n'y a pas d'équipe");
      }
    } else {
      throw new Exception("Pas le bon nombre d'arguments");
    }

  }
  
  public boolean checkArgs(String[] argument) {
    return argument.length == 2;
  }
  
  public static void main(String[] args) throws Exception{
    new Resultats(args);
  }

  

}
