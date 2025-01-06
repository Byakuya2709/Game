/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.game.state;

import com.game.main.Game;
import com.game.main.GamePanel;
import com.game.main.StateMethods;
import com.game.ui.MenuButton;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class Menu extends State implements StateMethods{
    public MenuButton[] buttons = new MenuButton[3];
    public BufferedImage backGround;
    private int menuX,menuY,menuWidth,menuHeight;
    
    public Menu(GamePanel game){
        super(game);
        loadButton();
        loadBackGroundImage();
        
    }
    public void loadBackGroundImage(){
        try {
            backGround=ImageIO.read(getClass().getResourceAsStream("/ui/background/backgroundMenu.png"));
//            menuWidth=(int)(backGround.getWidth()*GamePanel.scale);
//            menuHeight=(int)(backGround.getHeight()*GamePanel.scale);
//            menuX=GamePanel.width/2 -menuWidth/2;
//            menuY=(int)(45*GamePanel.scale);
            
            menuWidth=GamePanel.width;
            menuHeight=GamePanel.height;
            menuX=0;
            menuY=0;
            
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadButton(){
        buttons[0] = new MenuButton(GamePanel.width/2,(int)(150*GamePanel.scale),0,GameState.PLAYING);
        buttons[1] = new MenuButton(GamePanel.width/2,(int)(220*GamePanel.scale),1,GameState.OPTIONS);
        buttons[2] = new MenuButton(GamePanel.width/2,(int)(290*GamePanel.scale),2,GameState.QUIT);
}
    @Override
    public void update() {
        for(MenuButton mb : buttons){
            mb.update();
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(backGround, menuX,menuY,menuWidth,menuHeight, null);
        
       for(MenuButton mb : buttons){
            mb.draw(g);
        }
    }

    @Override
    public void test() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
         for(MenuButton mb : buttons){
            if(isIn(e,mb)){
                mb.setMousePressed(true);   
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
         for(MenuButton mb : buttons){
            mb.setMouseOver(false);
        }
         for(MenuButton mb : buttons){
             if(isIn(e,mb)){
                    mb.setMouseOver(true);
                    break;
             }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         for(MenuButton mb : buttons){
            if(isIn(e,mb)){
                if(mb.isMousePressed())
                        mb.applyGamestate();
                break;
            }
        }
         resetButton();
    }

    public void resetButton(){
        for(MenuButton mb : buttons){
            mb.resetBools();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            GameState.state =GameState.PLAYING;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
