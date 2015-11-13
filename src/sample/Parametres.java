package sample;

import javafx.scene.control.TextField;

/**
 * Created by 46989414t on 13/11/15.
 */
public class Parametres {
    String ciudad;
    int dias;

    Parametres(){
        ciudad=null;
        dias=0;
    }

    Parametres(String ciudad, int dias) {
        this.ciudad = ciudad;
        this.dias = dias;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}
