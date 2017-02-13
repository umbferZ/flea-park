/*
 * 
 * Created by Umberto Ferracci from urania's PC
 * email: umberto.ferracci@gmail.com
 * Project: fleaPark
 * Package: org.umbZfer.util.parser
 * Type: CSVProva
 * Last update: 13-feb-2017 7.07.17
 * 
 */
package org.umbZfer.util.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class CSVProva {
    public static void main(String[] args) {
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader("csv/table_comune.csv"), ',');
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null)
                // nextLine[] is an array of values from the line
                System.out.println(nextLine[0] + nextLine[1] + nextLine[2]);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try {
        // CSVWriter writer = new CSVWriter(new FileWriter("csv/yourfile2.csv"),
        // '\t');
        // String[] entries = "first#second#third".split("#");
        // writer.writeNext(entries);
        // writer.close();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

    }
}