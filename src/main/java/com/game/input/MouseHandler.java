/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.input;

import com.game.main.GamePanel;
import com.game.state.GameState;
import static com.game.state.GameState.MENU;
import static com.game.state.GameState.PLAYING;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author ADMIN
 */
public class MouseHandler implements MouseListener,MouseMotionListener{

     private GamePanel gp;
    
    public MouseHandler(GamePanel gp) {
        this.gp=gp;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        switch(GameState.state){
            case MENU ->{
               
                break;
            }
            case PLAYING ->{
                gp.playing.mouseClicked(e);
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(GameState.state){
            case MENU ->{
                gp.menu.mousePressed(e);
                break;
            }
            case PLAYING ->{
                gp.playing.mousePressed(e);
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(GameState.state){
            case MENU ->{
                gp.menu.mouseReleased(e);
                break;
            }
            case PLAYING ->{
                gp.playing.mouseReleased(e);
                break;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
         switch(GameState.state){
            case MENU ->{
             
                break;
            }
            case PLAYING ->{
               gp.playing.mouseDragged(e);
                break;
            }
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch(GameState.state){
            case MENU ->{
                gp.menu.mouseMoved(e);
                break;
            }
            case PLAYING ->{
               gp.playing.mouseMoved(e);
                break;
            }
        }
    }
    
}
