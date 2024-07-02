/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Level {
   public List<List<Integer>> tileMatrix = new ArrayList<>();
   String levelName;
   public Level(List tileMatrix,String levelName){
       this.levelName=levelName;
       this.tileMatrix=tileMatrix;
   }
    public Level(String levelName){
       this.levelName=levelName;
       loadTileMap();
   }
   
   
   private void loadTileMap() {
        try (InputStream is = getClass().getResourceAsStream("/maps/" + levelName);
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split(" ");
                List<Integer> rowList = new ArrayList<>();
                for (String value : values) {
                    rowList.add(Integer.valueOf(value));
                }
                tileMatrix.add(rowList);
            }
        } catch (IOException | NumberFormatException ex) {
            System.err.println("Error loading tile map: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
