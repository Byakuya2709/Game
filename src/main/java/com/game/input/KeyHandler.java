/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.input;

import com.game.main.GamePanel;
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
        int code =  e.getKeyCode();
     
        switch(code){
            case KeyEvent.VK_W -> {  
               this.gp.player.setUp(true);
            break;
            }
            case KeyEvent.VK_S -> {  
              this.gp.player.setDown(true);
            break;
            }
            case KeyEvent.VK_A -> {  
                  this.gp.player.setLeft(true);
            break;
            }
            case KeyEvent.VK_D -> { 
                this.gp.player.setRight(true);
            break;
            }
             case KeyEvent.VK_SPACE -> { 
                this.gp.player.setJump(true);
            break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
         int code =  e.getKeyCode();
         switch(code){
            case KeyEvent.VK_W -> {  
               this.gp.player.setUp(false);
            break;
            }
            case KeyEvent.VK_S -> {  
               this.gp.player.setDown(false);
            break;
            }
            case KeyEvent.VK_A -> {  
             this.gp.player.setLeft(false);
            }
            case KeyEvent.VK_D -> { 
             this.gp.player.setRight(false);
            break;
            }
             case KeyEvent.VK_SPACE -> { 
                this.gp.player.setJump(false);
            break;
            }
        }
    }
    
}
