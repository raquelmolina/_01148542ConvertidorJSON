package com.edu.mx.practica.uno.convertidor;
import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;

public class Convertidor {

    /**
     * Metodo para convertir Clase JAVA a JSON
     * @param m texto en forma clase para convertir
     * @return Clase convertida a JSON
     */
    public String Objecttojson(Object m) {
        Gson gson = new Gson();
        String resultado = gson.toJson(m);
        return resultado;
    }


    /**
     * Metodo para convertir XML a JSON
     * @param xml texto en forma XML para convertir
     * @return XML convertida a JSON
     */
    public String convertirJsonToClase (String xml){
        JSONObject xmlJson = XML.toJSONObject(xml);
        String xmlEnJason = xmlJson.toString(4);
        return xmlEnJason;
    }
}
