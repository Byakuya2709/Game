/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.ui;

import com.game.state.GameState;
import static com.game.utils.Constants.UI.Button.BUTTON_HEIGHT;
import static com.game.utils.Constants.UI.Button.BUTTON_WIDTH;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class SoundButton extends PauseButton{
    public int rowIndex,index;
    public BufferedImage[][] mapsImage;
    public boolean mouseOver,mousePressed;
     public boolean muted=false;
    
    public SoundButton(int xPos, int yPos, int width,int height){
        super(xPos,yPos,width,height); 
        loadImg();
    }
    
    
      public void loadImg() {
        mapsImage = new BufferedImage[2][3]; // Initialize the array with proper dimensions

        String[] imageNames = {
            "sound00.png", "sound01.png", "sound02.png",
            "sound10.png", "sound11.png", "sound12.png"
        };

        for (int i = 0; i < imageNames.length; i++) {
            try {
                BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/ui/button/menu/" + imageNames[i]));
                mapsImage[i / 3][i % 3] = img; // Populate the 2D array correctly
            } catch (IOException ex) {
                Logger.getLogger(SoundButton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void draw(Graphics2D g2){
        
        g2.drawImage(mapsImage[rowIndex][index], x, y, width, height, null);
    }
    public void update(){
        
     if (muted) {
            rowIndex = 1;
        } else
             rowIndex = 0;
     
        index = 0;
        if (mouseOver) {
            index = 1;
        }
        if (mousePressed) {
            index = 2;
        } 
    }

    public void resetBools(){
        mouseOver=false;
        mousePressed=false;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    

    
   
}
