/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.entity;

import com.game.main.GamePanel;
import static com.game.utils.Constants.Direction.DOWN;
import static com.game.utils.Constants.Direction.LEFT;
import static com.game.utils.Constants.Direction.RIGHT;
import static com.game.utils.Constants.Direction.UP;
import static com.game.utils.Constants.PlayerContants.FALLING;
import static com.game.utils.Constants.PlayerContants.IDLE;
import static com.game.utils.Constants.PlayerContants.JUMPING_RIGHT;
import static com.game.utils.Constants.PlayerContants.JUMPING_lEFT;
import static com.game.utils.Constants.PlayerContants.RUNNING_LEFT;
import static com.game.utils.Constants.PlayerContants.RUNNING_RIGHT;
import static com.game.utils.Constants.PlayerContants.getSpriteAmount;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import static com.game.utils.HelpMethod.*;
/**
 *
 * @author ADMIN
 */
public class Player extends Entity {
     int playerAction = RUNNING_LEFT;
     public boolean moving = false;
     int animationTick=0,animationIndex=0,animationSpeed=20;
     boolean left, up, right,down,jump;
     boolean inAir=false;
     //jump
     public float airSpeed=0f;
     public float jumpSpeed=-1.9f*GamePanel.scale;
     //đụng đầu
     public float fallSpeedAfterCollision=0.5f*GamePanel.scale;
     
     public float gravity=0.05f*GamePanel.scale;
     
     GamePanel gp;
     
     private float xDrawOffset=3*GamePanel.scale;
     private float yDrawOffset=5*GamePanel.scale;
    
    
    public Player() {
        super(0,0,3,32,32);
  
    }
     
    public Player(float x, float y,float speed,int width, int height, GamePanel gp) {
        super(x,y,speed,width,height);
        this.gp=gp;
        subImage = new BufferedImage[24];
        animation = new BufferedImage[8][3];
        loadAnimation();     
        initHitBox(x,y,(int)(24*gp.scale),(int)(24*gp.scale));
        
    }
      public void checkInAir() {
        if (!IsEntityOnFloor(hitbox, gp.playing.tileManager.level1.tileMatrix)) {
            inAir = true;
        } else {
            inAir = false;
        }
  }
      
    public void update(){
       updatePosition();
//       updateHitBox();
       
       updateAnimation();

       setAnimation();
        
       
    }
    public void draw(Graphics2D g2,int xLvlOffSet){
       g2.drawImage(animation[playerAction][animationIndex],(int)(hitbox.x-xDrawOffset)-xLvlOffSet,(int)(hitbox.y-yDrawOffset),width,height, null);
       drawHitBox(g2,xLvlOffSet);
    }
    
    public void resestDirection(){
    left=false;
    right=false;
    up=false;
    down=false;
}
    public void resetAnimationTick(){
        animationTick=0;
        animationIndex=0;
    }
    public void loadAnimation(){
        // load all tile
        for (int i =0; i<24;i++){
            
             try {
             subImage[i] = ImageIO.read(getClass().getResourceAsStream("/character/tile"+i+".png"));
         } catch (IOException ex) {
            ex.printStackTrace();
         }
        }
        
       // add animation 
      int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                animation[i][j] = subImage[k];
                k++;
            }
        }  
    }
    

    public void setAnimation(){
        int startAnimation = playerAction;
              if(inAir){
                    if (airSpeed > 0){
                       playerAction=FALLING;
                   } 
               }
           if (moving == true){
           if (right == true){
               if(inAir){
                   playerAction=JUMPING_RIGHT;
               } else
                playerAction=RUNNING_RIGHT;
           }
              
               
           else if (left == true)
               if(inAir){   
                playerAction=JUMPING_lEFT;
               }
                   else
                playerAction=RUNNING_LEFT;
          
           }     
           else playerAction=IDLE;
          
       
               if(inAir){
                    if (airSpeed > 0){
                       playerAction=FALLING;
                   } 
               }
           if (startAnimation != playerAction)
               resetAnimationTick();
       }
    
       public void updateAnimation(){
           animationTick++;
           if(animationTick >=animationSpeed){
            animationTick=0;
            animationIndex++;
            if(animationIndex>=getSpriteAmount(playerAction)){
                animationIndex=0;
            }
           }
       }
  
       public void updatePosition(){
            
             moving=false;
             
             if(jump) jump();
                 
             if(!left && !right && !inAir)
                 return;
             
            float xSpeed =0;
             
            if(left){
                xSpeed-=speed;
              
            }if(right){
                xSpeed+=speed;
              
            }
            if(!inAir){
                if(!IsEntityOnFloor(hitbox,gp.playing.tileManager.level1.tileMatrix)){
                    inAir=true;
                }
            }
            if (inAir){
                //giảm y
                if(CanMoveHere(hitbox.x,hitbox.y+airSpeed,hitbox.width,hitbox.height,gp.playing.tileManager.level1.tileMatrix)){
                    hitbox.y+=airSpeed;
                    airSpeed+=gravity;
                    updateXPosition(xSpeed);
                }
                else{
                    hitbox.y=GetEntityYPosUnderRoofOrAboveFloor(hitbox,airSpeed);
                    if(airSpeed>0) resetInAir();
                    else airSpeed = fallSpeedAfterCollision;
                    
                     updateXPosition(xSpeed);
                }
            }
            else  updateXPosition(xSpeed);
            
//            if(up && !down){
//                ySpeed-=speed;
//                
//            }else if(down && !up){
//                ySpeed+=speed;
//                
//            }
//            if(CanMoveHere(x+xSpeed,y+ySpeed,width,height,gp.tileManager.level1.tileMatrix)){
//                this.x+=xSpeed;
//                this.y+=ySpeed;
//                moving=true;
//            }
            
                moving = true;

       }
      public void updateXPosition(float xSpeed){
          if(CanMoveHere(hitbox.x+xSpeed,hitbox.y,hitbox.width,hitbox.height,gp.playing.tileManager.level1.tileMatrix)){
                hitbox.x+=xSpeed;
                moving=true;
            }
          else {
                hitbox.x= GetEntityXPosNextToWall(hitbox,xSpeed);
          }
      }
     public void jump(){
         if(inAir)
             return;
         inAir = true;
         airSpeed = jumpSpeed;
     } 
      
    public void resetInAir(){
        inAir=false;
        airSpeed=0;
    }
   
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }
       
       
}
