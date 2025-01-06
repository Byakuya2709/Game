/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.state;

import com.game.entity.EnemyManager;
import com.game.entity.Player;

import com.game.level.TileManager;
import com.game.main.Game;
import com.game.main.GamePanel;
import static com.game.main.GamePanel.tileSize;
import com.game.main.StateMethods;
import com.game.ui.PauseOverlay;
import static com.game.utils.Constants.Enviroment.*;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class Playing extends State implements StateMethods{
    public Player player;
    public TileManager tileManager;
    public EnemyManager enemyManager;
    
    BufferedImage bgImg,bigCloud;
    int[] cloudPos;
    Random random = new Random();
    
    public PauseOverlay pauseOverlay;
     public boolean paused = false;
     
     public int xLvlOffSet;
     
     public int leftBorder = (int)(0.2*GamePanel.width);
     public int rightBorder = (int)(0.8*GamePanel.width);
     
     public int lvlTilesWide;
     public int maxTilesOffset;
     public int maxLvlOffsetX;
     
     public Playing(GamePanel gp) {
        super(gp);
        initClasses();
        loadBackGroundImage();
        loadAnimationBG();
        
    }
    void loadAnimationBG(){ 
        cloudPos = new int[8];
        for (int i=0;i<cloudPos.length;i++){
            cloudPos[i]=(int)(90*GamePanel.scale) +random.nextInt((int)(100*GamePanel.scale));
        }
    }
    private void initClasses(){
       tileManager = new TileManager(gamePanel);
       player = new Player(200, 200, 2, GamePanel.tileSize, GamePanel.tileSize, gamePanel);
       enemyManager = new EnemyManager(this);
       pauseOverlay= new PauseOverlay(this);
       
       lvlTilesWide = tileManager.level1.tileMatrix.get(0).size();
       maxTilesOffset=lvlTilesWide-GamePanel.tile_in_width;
       maxLvlOffsetX=maxTilesOffset*GamePanel.tileSize;
       
    }
    public void windowFocusLost(){
        player.resestDirection();
    }   

    @Override
    public void update() {
         if(!paused) {
            player.update();
            checkCloseToBorder();
            enemyManager.update();
        }
         else{
            pauseOverlay.update();
            
         }
      
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(bgImg, 0, 0, GamePanel.width, GamePanel.height, null);
        drawCloud(g2);
        tileManager.draw(g2,xLvlOffSet);
        player.draw(g2,xLvlOffSet);
        enemyManager.draw(g2,xLvlOffSet);
         if(paused) {
            pauseOverlay.draw(g2);
        }
      
    }
    void checkCloseToBorder(){
        int playerX = (int)player.getHitBox().x;
        
        int diff = playerX - xLvlOffSet;
        
        if(diff > rightBorder)
                xLvlOffSet +=diff -rightBorder;
        else if (diff < leftBorder)
                xLvlOffSet+=diff- leftBorder;
        
        if (xLvlOffSet > maxLvlOffsetX)
            xLvlOffSet = maxLvlOffsetX;
        else if(xLvlOffSet<0)
            xLvlOffSet=0;
        
    }
    
    public void loadBackGroundImage(){
        try {
            bgImg=ImageIO.read(getClass().getResourceAsStream("/ui/background/background1.png"));
            bigCloud=ImageIO.read(getClass().getResourceAsStream("/ui/background/cloud.png"));
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void drawCloud(Graphics2D g2){
         for (int i=0;i<cloudPos.length;i++)
                g2.drawImage(bigCloud,(int)(CLOUD_WIDTH*4*i-xLvlOffSet*0.3),cloudPos[i], CLOUD_WIDTH, CLOUD_HEIGHT, gamePanel);
    }
    @Override
    public void test() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(paused){
            pauseOverlay.mousePressed(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
         if(paused){
            pauseOverlay.mouseMoved(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(paused){
            pauseOverlay.mouseReleased(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code =  e.getKeyCode();
     if (!paused){
          switch(code){
            case KeyEvent.VK_W -> {  
               this.player.setUp(true);
            break;
            }
            case KeyEvent.VK_S -> {  
              this.player.setDown(true);
            break;
            }
            case KeyEvent.VK_A -> {  
                  this.player.setLeft(true);
            break;
            }
            case KeyEvent.VK_D -> { 
                this.player.setRight(true);
            break;
            }
             case KeyEvent.VK_SPACE -> { 
                this.player.setJump(true);
                 break;
            }
            case KeyEvent.VK_ESCAPE -> { 
                GameState.state = GameState.MENU;
                 break;
            }
            case KeyEvent.VK_P -> { 
                PauseGame();
                 break;
            }
        }
     }
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code =  e.getKeyCode();
         switch(code){
            case KeyEvent.VK_W -> {  
               this.player.setUp(false);
            break;
            }
            case KeyEvent.VK_S -> {  
               this.player.setDown(false);
            break;
            }
            case KeyEvent.VK_A -> {  
             this.player.setLeft(false);
            }
            case KeyEvent.VK_D -> { 
             this.player.setRight(false);
            break;
            }
             case KeyEvent.VK_SPACE -> { 
                this.player.setJump(false);
            break;
            }
        }
    }
     public void unPauseGame(){
        paused=false;
    }
     public void PauseGame(){
        paused=true;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       if(paused){
            pauseOverlay.mouseDragged(e);
        }
    }
}
