package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Presentation {
    public static void main(String[] args) {
        //methode 1 annotation

            ApplicationContext ctx = new AnnotationConfigApplicationContext("daoI","metierI");
        IMetier metier =  ctx.getBean(IMetier.class);

            System.out.println(metier.calcul());



    }
}
