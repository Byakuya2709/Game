/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.ui;

import com.game.state.GameState;
import static com.game.utils.Constants.UI.Button.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
public class MenuButton {
    public int xPos,yPos,rowIndex,index;
    public int xOffsetCenter = BUTTON_WIDTH/2;
    public GameState state;
    public Map<String,BufferedImage> mapsImage = new HashMap<>();
    public boolean mouseOver,mousePressed;
    public Rectangle bounds;
    
    public MenuButton(int xPos, int yPos, int rowIndex, GameState state){
        this.xPos=xPos;
        this.yPos=yPos;
        this.rowIndex=rowIndex;
        this.state=state;   
        loadImg();
        initBounds();
    }
    
    public void initBounds(){
        bounds = new Rectangle(xPos-xOffsetCenter,yPos,BUTTON_WIDTH,BUTTON_HEIGHT);
    }
        public void loadImg() {
    String[] imageNames = {
        "button00.png", "button01.png", "button02.png",
        "button10.png", "button11.png", "button12.png",
        "button20.png", "button21.png", "button22.png"
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
        g2.drawImage(mapsImage.get("button"+rowIndex+value+".png"),xPos-xOffsetCenter,yPos,BUTTON_WIDTH,BUTTON_HEIGHT,null);
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
    public void applyGamestate(){
        GameState.state= state;
    }
    public void resetBools(){
        mouseOver=false;
        mousePressed=false;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
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

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
    
}
