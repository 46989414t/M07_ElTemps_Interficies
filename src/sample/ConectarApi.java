package sample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.lang.Object;
//import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.transform.Transformer;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by dremon on 09/11/15.
 */
public class ConectarApi {


    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();//retorna un JSON
    }

    public static void main(String[] args){
        String city="Barcelona";
        String unitats="metric";
        int dies=7;

        String s = "";
        String api_key = "4c3c9fd618e5d67bb93faf64733a3470";
        //16 dias: api.openweathermap.org/data/2.5/forecast/daily?q={city name},{country code}&cnt={cnt}
        //api.openweathermap.org/data/2.5/forecast/daily?q=London&mode=xml&units=metric&cnt=7
        //http://api.openweathermap.org/data/2.5/forecast/daily?q=London&mode=xml&units=metric&cnt=7&appid=4c3c9fd618e5d67bb93faf64733a3470

        //String peticio = "https://api.themoviedb.org/3/movie/"+film+"/credits?api_key="+api_key;
        String peticio2 = "http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=json&units="+unitats+"&cnt="+dies+"&appid="+api_key;

        /*try {
            s = getHTML(peticio2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SJS(s);*/

        for (int i = 0; i < dies; i++) {
            //int peli = 908 +i;
            //String film = String.valueOf(peli);
            //String peticio = "https://api.themoviedb.org/3/movie/"+film+"/credits?api_key="+api_key;
            try {
                s = getHTML(peticio2);
                SJS(s);
                //SJC(s);
            } catch (Exception e) {
                System.out.println("no existeix");
            }
        }


    }

    public static void SJS (String cadena) throws ParseException {

        Object obj02 = JSONValue.parse(cadena);
        JSONObject arra02=(JSONObject)obj02;

        String out = arra02.toJSONString();

        System.out.println("**********************************************");
        System.out.println("llega a SJS");
        //System.out.println(out);
        //Ciutats
        JSONObject respostaCity = (JSONObject)arra02.get("city");
        //System.out.println(arra02.get("city");
        System.out.println("Nombre: "+respostaCity.get("name"));
        //System.out.println("pais: "+arra02.get("country"));
        //System.out.println("population: "+arra02.get("population"));

        //COD
        System.out.println("llega a cod");
        //JSONObject respostaCod = (JSONObject)arra02.get("aaaaa");
        System.out.println("COD"+arra02.get("cod"));
        //System.out.println(respostaCod);

        //message
        System.out.println("MESSAGE: "+arra02.get("message"));

        //cnt
        System.out.println("CNT: "+arra02.get("cnt"));
        //List
        System.out.println("llega al lista");
        JSONArray respostaList = (JSONArray)arra02.get("list");

        //System.out.println("LISTA: "+respostaList.get("list"));
        //System.out.println("DT: "+respostaList.get(Integer.parseInt("dt")));

        for (int i =0; i < respostaList.size(); i++){
            //System.out.println("llega al primer for");
            //System.out.println("elementos del array: "+respostaList.size());

            //8System.out.println("DT: "+respostaList.get(Integer.parseInt("dt")));
            JSONObject listJasonObj = (JSONObject)respostaList.get(i);
            Double rain = (Double)listJasonObj.get("rain");
            System.out.println(rain);


            //arrayTemp.get(Integer.parseInt("temp"));
            /*JSONArray respostaTemp = (JSONArray)arrayTemp.get(Integer.parseInt("temp"));
            System.out.println(respostaTemp.get(Integer.parseInt("max")));*/
                    //(JSONArray)respostaList.get(i);
            //System.out.println(arrayTemp.get(Integer.parseInt("temp")));

            /*for(int j=0; j<respostaTemp.size(); j++){
                System.out.println("llega al segundo for");
                JSONObject arrayMin = (JSONObject) arrayTemp.get(j);
                System.out.println("Mínima:"+arrayMin.get(Integer.parseInt("min")));
            }*/
        }
        //System.out.println(respostaList.get("temp"));
        //System.out.println(resposta.get("clouds"));

        // System.out.println(arra02.get(""));


    }

    public static void SJC (String cadena){
        Object obj02 = JSONValue.parse(cadena);
        JSONObject arra02=(JSONObject)obj02;
        JSONArray arra03 = (JSONArray)arra02.get("cast");

        for (int i = 0; i < arra03.size(); i++) {

            JSONObject jb= (JSONObject)arra03.get(i);
            System.out.println(jb.get("character")+"<-->"+jb.get("name"));

        }

    }

}
