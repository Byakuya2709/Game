/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.main;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

/**
 *
 * @author ADMIN
 */
public class GameWindow {
    private JFrame frame;
  
    public GameWindow(GamePanel gp){
        frame = new JFrame();
        
        
       
        frame.setResizable(false);
        
        frame.add(gp);
        frame.pack();
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.addWindowFocusListener(new WindowFocusListener(){
            @Override
            public void windowGainedFocus(WindowEvent e) {
                gp.windowFocusLost();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
            }
            
        }
);
    }
}
