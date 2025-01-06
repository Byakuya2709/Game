/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.ui;

import com.game.main.GamePanel;
import com.game.state.GameState;
import com.game.state.Playing;
import static com.game.utils.Constants.UI.PauseButton.SOUND_SIZE;
import static com.game.utils.Constants.UI.URMButton.URM_SIZE;
import static com.game.utils.Constants.UI.VolumeButton.SLIDER_WIDTH;
import static com.game.utils.Constants.UI.VolumeButton.VOLUME_HEIGHT;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class PauseOverlay {
    public BufferedImage bgImg;
    public Playing playing;
    public int bgX,bgY,bgW,bgH;
    public SoundButton musicBtn,sfxBtn;
    public URMButton menuBtn,unPauseBtn,replayBtn;
    public VolumeButton volumeBtn;
    
    public PauseOverlay(Playing playing) {
        this.playing=playing;
        loadBGImage();
        createSoundButton();
        createUrmButton();
        createVolumeButton();
        
    }
    public void update(){
        musicBtn.update();
        sfxBtn.update();
        
        
        menuBtn.update();
        replayBtn.update();
        unPauseBtn.update();
        
        volumeBtn.update();
        
    }
     public void createSoundButton(){
        int soundX=(int)(450*GamePanel.scale);
        int musicY=(int)(140*GamePanel.scale);
        int sfxY=(int)(185*GamePanel.scale);
        musicBtn = new SoundButton(soundX,musicY,SOUND_SIZE,SOUND_SIZE);
        sfxBtn = new SoundButton(soundX,sfxY,SOUND_SIZE,SOUND_SIZE);
    }
    void createUrmButton(){
        int menuX=(int)(313*GamePanel.scale);
        int replayX=(int)(387*GamePanel.scale);
        int unpauseX=(int)(462*GamePanel.scale);
        int bY=(int)(300*GamePanel.scale);
        
        menuBtn= new URMButton(menuX,bY,URM_SIZE,URM_SIZE,0);
        replayBtn= new URMButton(replayX,bY,URM_SIZE,URM_SIZE,1);
        unPauseBtn=new URMButton(unpauseX,bY,URM_SIZE,URM_SIZE,2);
    }
    void createVolumeButton(){
        int vX=(int)(309*GamePanel.scale);
        int vY=(int)(240*GamePanel.scale);
        volumeBtn = new VolumeButton(vX,vY,SLIDER_WIDTH,VOLUME_HEIGHT);
    }
    public void loadBGImage(){
        try {
            bgImg=ImageIO.read(getClass().getResourceAsStream("/ui/background/backgroundMenu.png"));
            bgW=(int)(300*GamePanel.scale);
            bgH=(int)(300*GamePanel.scale);
            bgX=GamePanel.width/2 -bgW/2;
            bgY=(int)(60*GamePanel.scale);
        } catch (IOException ex) {
            Logger.getLogger(PauseOverlay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(bgImg,bgX,bgY,bgW,bgH,null);
        musicBtn.draw(g2);
        sfxBtn.draw(g2);
        
        
        menuBtn.draw(g2);
        replayBtn.draw(g2);
        unPauseBtn.draw(g2);
        
        volumeBtn.draw(g2);
    }
   
    
    public void mouseDragged(MouseEvent e){
        if(volumeBtn.isMousePressed()){
            volumeBtn.changeX(e.getX());
        }
        
    }
     public void mousePressed(MouseEvent e) {
        if (isIn(e, musicBtn)) 
            musicBtn.setMousePressed(true);
         else if (isIn(e, sfxBtn)) 
            sfxBtn.setMousePressed(true);
         
         else if(isIn(e, menuBtn)){
             menuBtn.setMousePressed(true);
         }
        else if(isIn(e, replayBtn)){
             replayBtn.setMousePressed(true);
         }
        else if(isIn(e, unPauseBtn)){
             unPauseBtn.setMousePressed(true);
         }
        else if(isIn(e, volumeBtn)){
             volumeBtn.setMousePressed(true);
         }
        
    }

    public void mouseReleased(MouseEvent e) {
        if (isIn(e, musicBtn)) {
            if (musicBtn.isMousePressed()==true) 
                musicBtn.setMuted(!musicBtn.isMuted());
            
        } else if (isIn(e, sfxBtn)) {
            if (sfxBtn.isMousePressed()) {
                sfxBtn.setMuted(!sfxBtn.isMuted());
            }
        }
        else if (isIn(e, menuBtn)) {
            if (menuBtn.isMousePressed()) {
                GameState.state=GameState.MENU;
                playing.unPauseGame();
            }
        }
         else if (isIn(e, replayBtn)) {
            if (replayBtn.isMousePressed()) {
                System.out.println("replay");
            }
        }
        else if (isIn(e, unPauseBtn)) {
            if (unPauseBtn.isMousePressed()) {
                playing.unPauseGame();
            }
        }
       
        
        
        musicBtn.resetBools();
        sfxBtn.resetBools();
        
        menuBtn.resetBools();
        replayBtn.resetBools();
        unPauseBtn.resetBools();
        volumeBtn.resetBools();
    }

    public void mouseMoved(MouseEvent e) {
        musicBtn.setMouseOver(false);
        sfxBtn.setMouseOver(false);
        
        menuBtn.setMouseOver(false);
        replayBtn.setMouseOver(false);
        unPauseBtn.setMouseOver(false);
        
        volumeBtn.setMouseOver(false);
        
        if (isIn(e, musicBtn)) {
            musicBtn.setMouseOver(true);
        } else if (isIn(e, sfxBtn)) {
            sfxBtn.setMouseOver(true);
        }
        else if (isIn(e, menuBtn)) {
            menuBtn.setMouseOver(true);
        }else if (isIn(e, replayBtn)) {
            replayBtn.setMouseOver(true);
        }else if (isIn(e, unPauseBtn)) {
            unPauseBtn.setMouseOver(true);
        }
        else if (isIn(e, volumeBtn)) {
            volumeBtn.setMouseOver(true);
        }
    }

    public boolean isIn(MouseEvent e, PauseButton b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }
   
}
