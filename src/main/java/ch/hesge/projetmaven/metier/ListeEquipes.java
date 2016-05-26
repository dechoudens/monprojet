package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.base.EquipeDao;
import ch.hesge.projetmaven.domaine.Equipe;
import java.util.*;

/**
 * @author Antoine de Choudens
 */
public class ListeEquipes {
  private List<Equipe> liste;
  

  public ListeEquipes(EquipeDao equipeDao) {
    liste = equipeDao.getListeEquipe();
  }

  public boolean isEmpty(){
    return liste.isEmpty();
  }

  public void afficherResultatsEquipe() {
    Iterator it = liste.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
  
}
