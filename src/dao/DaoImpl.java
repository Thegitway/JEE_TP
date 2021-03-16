package dao;

public class DaoImpl implements IDao{
    @Override
    public double getData(){
        System.out.println("Version de base de données");
        double data=33;
        return data;
    }
}
