/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.state;

import com.game.level.*;
import com.game.main.Game;
import com.game.main.GamePanel;
import com.game.ui.MenuButton;
import java.awt.event.MouseEvent;

/**
 *
 * @author ADMIN
 */
public class State {
    public GamePanel gamePanel;
    public State(GamePanel game){
        this.gamePanel=game; 
    }
    public boolean isIn(MouseEvent e, MenuButton mb){
        return mb.getBounds().contains(e.getX(),e.getY());
    }
}
