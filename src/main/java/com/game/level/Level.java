/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.level;

import com.game.main.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Level {
   public List<List<Integer>> tileMatrix = new ArrayList<>();
   String levelName;
   public Level(List<List<Integer>> tileMatrix, String levelName){
        this.levelName = levelName;
        this.tileMatrix = tileMatrix;
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
   public void draw(Graphics2D g2,Map<String, Tile> tileMap,int xLvlOffSet){
       int tileWidth = GamePanel.tileSize;
        int tileHeight = GamePanel.tileSize;

        for (int worldRow = 0; worldRow < GamePanel.tile_in_height; worldRow++) {
            for (int worldCol = 0; worldCol < this.tileMatrix.get(worldRow).size(); worldCol++) {
                
                int tileValue = this.tileMatrix.get(worldRow).get(worldCol);
                if(tileValue!=0){
                    String tileName = TileManager.getTileName(tileValue);

                Tile tile = tileMap.get(tileName);
                int worldX = worldCol * tileWidth-xLvlOffSet;
                int worldY = worldRow * tileHeight;
                

                if (tile != null && tile.image != null) {
                    g2.drawImage(tile.image, worldX, worldY, tileWidth, tileHeight, null);
                }
                }
                
            }
        }
   }
   
}
