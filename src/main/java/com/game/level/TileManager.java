package com.game.level;

import com.game.main.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

public class TileManager {
    private final GamePanel gamePanel;
    private final Map<String, Tile> tileMap;
//    private final List<List<Integer>> tileMatrix = new ArrayList<>();
    
    private List<Level> maps = new ArrayList<>();
    private static final int GRASS = 0;
    private static final int WALL = 1;
    private static final int WATER = 2;
    private static final int TREE = 3;
    
    public Level level1;
    
    public TileManager(GamePanel gp) {
        this.gamePanel = gp;
        this.tileMap = new HashMap<>();
        loadTileImages();
        loadMap();
    }

   public void loadMap(){
         level1= new Level("map1.txt");
         maps.add(level1);
   }

    
    
    private void loadTileImages() {
        addTileImage("grass", "/tile/grass.png", false);
        addTileImage("wall", "/tile/wall.png", true);
        addTileImage("water", "/tile/water.png", false);
        addTileImage("tree", "/tile/tree.png", true);
        // Add more tiles as needed
    }

    private void addTileImage(String tileName, String imagePath, boolean collision) {
        try {
            Tile tile = new Tile();
            tile.image = ImageIO.read(getClass().getResourceAsStream(imagePath));
            tile.collision = collision;
            tileMap.put(tileName, tile);
        } catch (IOException ex) {
            System.err.println("Error loading tile image for " + tileName + ": " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void update(){
        
    }
    public void draw(Graphics2D g2) {
        int tileWidth = gamePanel.tileSize;
        int tileHeight = gamePanel.tileSize;

        for (int worldRow = 0; worldRow < level1.tileMatrix.size(); worldRow++) {
            for (int worldCol = 0; worldCol < level1.tileMatrix.get(worldRow).size(); worldCol++) {
                
                int tileValue = level1.tileMatrix.get(worldRow).get(worldCol);
                
                String tileName = getTileName(tileValue);

                Tile tile = tileMap.get(tileName);
                int worldX = worldCol * tileWidth;
                int worldY = worldRow * tileHeight;

                if (tile != null && tile.image != null) {
                    g2.drawImage(tile.image, worldX, worldY, tileWidth, tileHeight, null);
                }
            }
        }
    }

    private String getTileName(int tileValue) {
        switch (tileValue) {
            case WALL: return "wall";
            case WATER: return "water";
            case TREE: return "tree";
            case GRASS:
            default: return "grass";
        }
    }

    public static String findTile(int tileValue) {
        switch (tileValue) {
            case WALL: return "wall";
            case WATER: return "water";
            case TREE: return "tree";
            case GRASS:
            default: return "grass";
        }
    }
}
