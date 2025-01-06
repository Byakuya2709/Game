/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.ui;

import static com.game.utils.Constants.UI.VolumeButton.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class VolumeButton extends PauseButton {
    
    BufferedImage imgs[];
     BufferedImage slider;
     public int index=0;
     public boolean mouseOver,mousePressed;
     public int buttonX,minX,maxX;
    
    public VolumeButton(int x, int y, int width, int height) {
        //create bound for a button in the middle
        super(x+width/2, y, VOLUME_WIDTH, height);
        bounds.x-=VOLUME_WIDTH/2;
        buttonX=x+width/2;
        
        this.x=x;
        this.width=width;
        
        minX=x+VOLUME_WIDTH/2;
        maxX=x+width;
        
        
        loadImgs();
    }
     void loadImgs() {
        imgs = new BufferedImage[3];     
        for (int i = 0; i < 3; i++) {
            try {
                BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/ui/button/menu/volume" + i + ".png"));
                imgs[i] = img;
            } catch (IOException ex) {
                Logger.getLogger(SoundButton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            slider = ImageIO.read(getClass().getResourceAsStream("/ui/button/menu/slider.png"));
        } catch (IOException ex) {
            Logger.getLogger(VolumeButton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(){
        
        index = 0;
        if (mouseOver) {
            index = 1;
        }
        if (mousePressed) {
            index = 2;
        } 
        
    }
    public void draw(Graphics2D g2){
        g2.drawImage(slider, x, y, width, height, null);
        g2.drawImage(imgs[index],buttonX-VOLUME_WIDTH/2, y, VOLUME_WIDTH, height, null);
    }

    public void changeX(int x){
        if(x<minX)
            buttonX= minX;
            else if(x>maxX)
                   buttonX=maxX;
            else buttonX=x;
         
        
        bounds.x=buttonX;
        
    }
     public void resetBools(){
        mouseOver=false;
        mousePressed=false;
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
