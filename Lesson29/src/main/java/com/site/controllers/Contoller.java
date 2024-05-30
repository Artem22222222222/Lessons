package com.site.controllers;

import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

@Controller
public class Contoller {
    public String[] joke() {
        String apiUrl = "https://official-joke-api.appspot.com/random_joke";
        String[] joke = {"", ""};

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int status = con.getResponseCode();
            if (status == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();

                JSONObject json = new JSONObject(content.toString());
                joke[0] = json.getString("setup")+System.lineSeparator();
                joke[1] += json.getString("punchline");
            } else {
                System.out.println("Error: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joke;
    }
}
