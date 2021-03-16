package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation {
    public static void main(String[] args) throws Exception{
        //methode 1 using scanner
     try {
         File f=new File("config.txt");
         Scanner scanner = new Scanner(f);
         //dao
         String daoCalssName = scanner.nextLine();
         Class cdao = Class.forName(daoCalssName);
         IDao dao = (IDao) cdao.newInstance();
         //metier
         String metierCalssName = scanner.nextLine();
         Class cmetier = Class.forName(metierCalssName);
         IMetier metier = (IMetier) cmetier.newInstance();
         Method m= cmetier.getMethod("setDao",IDao.class);
         m.invoke(metier,dao);

         System.out.println(metier.calcul());

     }catch(Exception e)
     {
       System.out.println("Erreur : "+e);
     }


    }
}
