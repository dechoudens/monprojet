package ch.hesge.projetmaven.metier;

import ch.hesge.projetmaven.base.EquipeDao;
import ch.hesge.projetmaven.domaine.Equipe;
import com.google.common.annotations.VisibleForTesting;
import java.util.*;

/**
 * @author Antoine de Choudens
 */
public class ListeEquipes {
  private List<Equipe> liste;

  public ListeEquipes() {
    EquipeDao equipeDao = new EquipeDao();
    liste = equipeDao.getListeEquipe();
  }

  public boolean isEmpty(){
    return liste.size() == 0;
  }

  public void afficherResultatsEquipe() {
    Iterator it = liste.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
  
  @VisibleForTesting
  List getListe(){
    return liste;
  }
  
  @VisibleForTesting
  void setListe(List equipe){
    this.liste = equipe;
  }
  
}
