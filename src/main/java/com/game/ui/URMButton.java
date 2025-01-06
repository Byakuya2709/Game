/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.ui;

import java.awt.Graphics2D;
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
public class URMButton extends PauseButton{
    public Map<String,BufferedImage> mapsImage = new HashMap<>();
    public int rowIndex,index;
    public boolean mouseOver,mousePressed;
       
    public URMButton(int x, int y, int width, int height,int rowIndex) {
        super(x, y, width, height);
         this.rowIndex=rowIndex;
          loadImg();
         
    }
  

    
    public void loadImg() {
        String[] imageNames = {
        "urm00.png", "urm01.png", "urm02.png",
        "urm10.png", "urm11.png", "urm12.png",
        "urm20.png", "urm21.png", "urm22.png"
    };

        for (String imageName : imageNames) {
        try {
            BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/ui/button/menu/" + imageName));
            mapsImage.put(imageName, img);
        } catch (IOException ex) {
            Logger.getLogger(MenuButton.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
    }
     public void draw(Graphics2D g2){
        String value = String.valueOf(index);
        
        g2.drawImage(mapsImage.get("urm"+rowIndex+value+".png"), x, y, width, height, null);
    }
     public void update(){
        index =0;
    
    if(mouseOver){
        index=1;
    }
    if(mousePressed){
        index=2;
    }
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
