package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;


public class Presentation {
    public static void main(String[] args) throws Exception{
        //methode 1 xml
        try {
            File f=new File("config1.xml");
            ApplicationContext ctx = new ClassPathXmlApplicationContext(f.getPath());
            IMetier metier = (IMetier) ctx.getBean("metier");
            System.out.println(metier.calcul());
        }catch(Exception e)
        {
            System.out.println("Erreur : "+e.getMessage());
        }


    }
}
