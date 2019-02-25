package com.edu.mx.practicas;

import com.google.gson.Gson;
import lombok.Data;
import java.lang.Object;

public class ejemplo{
    @Data
    class Raquel {
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        private  String nombre = "Raquel";
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        String string = "public class Main {\n" +
                "    public static class CJava {\n" +
                "        public String getNombre() {\n" +
                "            return nombre;\n" +
                "        }\n" +
                "\n" +
                "        public void setNombre(String nombre) {\n" +
                "            this.nombre = nombre;\n" +
                "        }\n" +
                "\n" +
                "        private String nombre = \"Raquel\";\n" +
                "    }\n" +
                "}";
        String[] parts = string.split(" ");
        String part1 = parts[0];
        String part2 = parts[1];

        Gson gson = new Gson();
        if("public".equals(part1)){
            Class C = Class.forName("Main");
            Object obj = C.newInstance();
            System.out.println(obj);
            String valor = (String) obj;
            System.out.println(valor + "valor");
            String claseEnJSON = gson.toJson(obj);
            System.out.println(claseEnJSON);
        }
/*
        if("class".equals(part2)){
            Class.forName(part3).newInstance();
        }

        if("class".equals(part3)){
            Class.forName(part4).newInstance();
        }
        */

    }
}

