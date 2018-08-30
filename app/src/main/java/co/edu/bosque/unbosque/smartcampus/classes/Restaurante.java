package co.edu.bosque.unbosque.smartcampus.classes;

/**
 * Created by SYSTEM on 20/07/2018.
 */

public class Restaurante {

    private String tituloRestaurante;
    private String informacionRestaurante;

    public Restaurante(String pTituloRestaurante,String pInformacionRestaurante){
        tituloRestaurante=  pTituloRestaurante;
        this.informacionRestaurante=pInformacionRestaurante;
    }

    public void cambiarTituloRestaurante(String pTitulo){
        tituloRestaurante = pTitulo;
    }

    public String darTituloRestaurante(){
        return tituloRestaurante;
    }

    public void cambiarInformacionRestaurante(String pInformacion){
        informacionRestaurante = pInformacion;
    }

    public String darInformacionRestaurante(){
        return informacionRestaurante;
    }

}
