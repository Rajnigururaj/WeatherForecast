package com.excel.lib.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Txt_Reader {

    public static void main(String[] args) {

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("/Users/rajnigururajaacharya/Documents/GitHub/WeatherForecast/weather/src/main/java/com/inputfiles/locators.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                	br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
