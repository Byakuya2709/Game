/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.main;

import com.game.entity.Player;

/**
 *
 * @author ADMIN
 */
public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS=60;
    private final int UPS=90;
    
    
    public Game(){
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        startGameLoop();
    }
    
    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
   
    @Override
    public void run() {
        double timePerFrame = 1000000000.0/FPS;
        double timePerUpdate = 1000000000.0/UPS;
        
        long lastFrame = System.nanoTime();
        long previousTime = System.nanoTime();
        long now =System.nanoTime();
       
        
        int frame =0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();
        
        double deltaU = 0;
        double deltaF = 0;
        while(gameThread != null){
            long currentTime = System.nanoTime();
            now =System.nanoTime();
            
            
            deltaU+=(currentTime-previousTime)/timePerUpdate;
            deltaF+=(currentTime-previousTime)/timePerFrame;
            previousTime=currentTime;
            
            if (deltaU>=1){
                //update();
                gamePanel.update();
                updates++;
                deltaU--;
            }
             if (deltaF>=1){
                 //DRAW();
                gamePanel.repaint();
                frame++;
                deltaF--;
            }
            
//            if(now - lastFrame >= timePerFrame){
//                  gamePanel.repaint();
//                  lastFrame = now;
//                  frame++;
//            }
            
            
            if (System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck =System.currentTimeMillis();
            System.out.println("FPS: " +frame +" || UPS: "+ updates);
            frame=0;
            updates=0;
        }
        }
    }
   
public static void main(String[] args){
       Game game = new Game();
   
     }
}
