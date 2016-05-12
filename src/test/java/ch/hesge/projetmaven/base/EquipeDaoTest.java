/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.projetmaven.base;

import java.io.File;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author meckanik
 */
public class EquipeDaoTest {
  EquipeDao equipeDao;
  ClassLoader classLoader = getClass().getClassLoader();
  File file;
  
  @BeforeMethod
  public void setUp() throws Exception { 
   
  }
}
