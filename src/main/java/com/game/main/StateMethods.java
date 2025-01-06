/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.game.main;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author ADMIN
 */
public interface StateMethods {
    public void update();
    public void draw(Graphics2D g);
    public void test();
    
    public void mouseClicked(MouseEvent e);
    public void mousePressed(MouseEvent e);
    public void mouseMoved(MouseEvent e);
    public void mouseReleased(MouseEvent e);
    public void mouseDragged(MouseEvent e);
    
    public void keyPressed(KeyEvent e);
    public void keyReleased(KeyEvent e);
}
