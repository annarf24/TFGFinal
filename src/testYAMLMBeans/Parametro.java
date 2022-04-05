package testYAMLMBeans;

public class Parametro {
    private String name;
    private int num;
    private String[] atributs;

    public Parametro () {

    }

    public Parametro (String n, int nu, String[] a){
        name = n;
        num = nu;
        atributs = a;
    }

    public void setName (String n){
        name = n;
    }

    public void setNum (int n){
        num = n;
    }

    public void setAtributs (String[] a){
        atributs = a;
    }

    public String getName(){
        return name;
    }

    public int getNum() {
        return num;
    }

    public String[] getAtributs() {
        return atributs;
    }
}
