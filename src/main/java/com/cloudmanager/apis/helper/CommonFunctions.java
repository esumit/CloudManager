package com.cloudmanager.apis.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class CommonFunctions {
    public static String getJSONInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String data = "";
        String line;
        while ((line = reader.readLine()) != null) {
            data += line + "\n";
        }
        return data;
    }

}
