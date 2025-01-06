/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.input;

import com.game.main.GamePanel;
import com.game.state.GameState;
import static com.game.utils.Constants.Direction.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ADMIN
 */
public class KeyHandler implements KeyListener{
    private GamePanel gp;
    public KeyHandler(GamePanel gp) {
        this.gp=gp;
    }

    
    
    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
          switch(GameState.state){
            case MENU ->{
                gp.menu.keyPressed(e);
                break;
            }
            case PLAYING ->{
                gp.playing.keyPressed(e);
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
         switch(GameState.state){
            case MENU ->{
                gp.menu.keyReleased(e);
                break;
            }
            case PLAYING ->{
                gp.playing.keyReleased(e);
                break;
            }
        }
    }
    
}
