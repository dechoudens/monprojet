package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.domaine.Coureur;
import ch.hesge.projetmaven.domaine.Equipe;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Antoine de Choudens
 */
public class ListeEquipe {

  private ArrayList<Equipe> liste;

  public ListeEquipe() {
    liste = new ArrayList();
  }

  public final int size() {
    return liste.size();
  }

  public void ajouterCoureurDerniereEquipe(Coureur c) {
    Equipe e = getDerniereEquipe();
    e.addCoureur(c);
  }

  public void add(Equipe e) {
    liste.add(e);
  }

  public Equipe getDerniereEquipe() {
    int derniereEquipe = liste.size() - 1;
    Equipe equipe = liste.get(derniereEquipe);

    return equipe;
  }

  public void afficherEquipe() {
    Iterator it = liste.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }

}
