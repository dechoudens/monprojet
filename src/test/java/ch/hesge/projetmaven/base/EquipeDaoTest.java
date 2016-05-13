/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.projetmaven.base;

import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * @author meckanik
 */
public class EquipeDaoTest {
  
  @Test
  public void getListeEquipe_returns_list_of_Equipe() {
    Fichier mockedFichierCoureur = mock(Fichier.class);
    when(mockedFichierCoureur.size()).thenReturn(2);
    when(mockedFichierCoureur.isEOF()).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(true);
    when(mockedFichierCoureur.isLigneEquipe()).thenReturn(false);
    when(mockedFichierCoureur.getLigneCourante()).thenReturn("DUPONT;Jean;M;32.1;Heineken");
    
    Fichier mockedFichierEquipe = mock(Fichier.class);
    when(mockedFichierCoureur.size()).thenReturn(1);
    when(mockedFichierCoureur.isEOF()).thenReturn(false).thenReturn(false).thenReturn(true);
    when(mockedFichierCoureur.isLigneEquipe()).thenReturn(false);
    when(mockedFichierCoureur.getLigneCourante()).thenReturn("Heineken;2");
    
    EquipeDao equipeDaoTest = new EquipeDao(mockedFichierEquipe, mockedFichierCoureur);
    List coureurs = equipeDaoTest.getListeEquipe();
    for (Object coureur : coureurs) {
      assertTrue(coureur.equals(equipeDaoTest));
    }
    
  }
  
}
