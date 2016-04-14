package dechoudens.projetmaven;

import java.util.*;

/**
 * Tour du Canton de Genève
 *
 * @author: Antoine de Choudens
 *
 */
public class Resultats {

    private ArrayList equipes = new ArrayList();

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
                creerEquipe(strLigne);
                break;
            case 4:
                creerCoureur(strLigne);
                break;
        }
    }

    public void creerCoureur(StringTokenizer strLigne) {
        String nomCoureur = strLigne.nextToken();
        String prenom = strLigne.nextToken();
        char sexe = (strLigne.nextToken()).charAt(0);
        double temps = Double.parseDouble(strLigne.nextToken());
        Coureur c = new Coureur(nomCoureur, prenom, sexe, temps);
        
        int derniereEquipe = equipes.size() - 1;
        Equipe equipe = (Equipe) equipes.get(derniereEquipe);
        equipe.addCoureur(c);
    }

    public void creerEquipe(StringTokenizer strLigne) {
        String nomEquipe = strLigne.nextToken();
        int nbCoureur = Integer.parseInt(strLigne.nextToken());
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