package edu.upc.eetac.dsa.Mysql.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marc on 1/10/15.
 */

public class PiecesandProviders {
	
   //list is working as a database
   List<Pieces> piezas;
   List<Providers> proveedores;

   public PiecesandProviders(){
       piezas = new ArrayList<Pieces>();
       proveedores = new ArrayList<Providers>();
   }

    public List<Pieces> getPiezas() {
        return piezas;
    }

    public List<Providers> getProveedores() {
        return proveedores;
    }

    public void AnadirPieza(String Text, int Code)
    {
        Pieces nuevaPieza = new Pieces(Code,Text);
        piezas.add(nuevaPieza);
    }
    public void AnadirProvedores(String Code, String Name)
    {
        Providers nuevaProv = new Providers(Code, Name);
        proveedores.add(nuevaProv);
    }
}