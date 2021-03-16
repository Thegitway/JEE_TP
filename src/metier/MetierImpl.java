package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metierI")
public class MetierImpl implements IMetier{

    //couplage faible
    @Autowired
    private IDao dao;

    /*
     * Pour injecter la variable dao
     * a un objet d'une classe qui implémente IDao
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {

        double data=dao.getData();
        double res=data*Math.PI;
        return res;
    }
}
