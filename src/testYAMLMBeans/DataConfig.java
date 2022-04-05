package testYAMLMBeans;

public class DataConfig {
    private String nodo;
    private Parametro[] parametros;

    public DataConfig() {

    }

    public DataConfig(String n, Parametro[] p){
        nodo = n;
        parametros = p;
    }

    public void setNodos (String n) {
        nodo = n;
    }

    public void setParametros (Parametro[] p) {
        parametros = p;
    }

    public String getNodo() {
        return nodo;
    }

    public Parametro[] getParametros() {
        return parametros;
    }
}
