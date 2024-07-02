/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.main;

import com.game.entity.Player;
import com.game.input.KeyHandler;
import com.game.input.MouseHandler;
import com.game.level.TileManager;
import static com.game.utils.Constants.Direction.*;

import static com.game.utils.Constants.PlayerContants.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class GamePanel extends JPanel{
        Game game;
     KeyHandler keyboard = new KeyHandler(this);
     MouseHandler mouse = new MouseHandler(this);
     
      public final static int tileDefaultSize =32;
      public final static  float scale =1.5f;
      public final static int tile_in_width=26;
      
     public final static int tile_in_height=14;
     public final static int tileSize = (int)(tileDefaultSize*scale);
     
      
     
     //40 row x 25 col for 32x32 pixel

     public final static int width =tileSize*tile_in_width;
     public final static int height =tileSize*tile_in_height;
     
    
     public GamePanel(Game game) {
       this.game= game;
       this.addKeyListener(keyboard);
       this.addMouseListener(mouse);
       this.addMouseMotionListener(mouse);
       
       
       initClasses();
       
       
       this.setDoubleBuffered(true);
       this.setFocusable(true);
       this.requestFocus();
       this.setPreferredSize(new Dimension(width,height));
       
    }
    
       public Player player;
       public TileManager tileManager = new TileManager(this);
       
       private void initClasses(){
       player = new Player(200,200,2,tileSize,tileSize,this);
    }
       
     public void windowFocusLost(){
        player.resestDirection();
    }   
    public void update(){
        player.update();
    }
    public void draw(Graphics2D g2){
        player.draw(g2);
    }
      
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        draw(g2); 
        
        
        
        g2.dispose();
    }
    
   
}
