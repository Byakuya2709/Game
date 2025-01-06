/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.entity;

import com.game.main.GamePanel;
import com.game.utils.Constants;
import static com.game.utils.Constants.Direction.LEFT;
import static com.game.utils.Constants.EnemyContants.*;
import static com.game.utils.HelpMethod.CanMoveHere;
import static com.game.utils.HelpMethod.GetEntityYPosUnderRoofOrAboveFloor;
import static com.game.utils.HelpMethod.IsEntityOnFloor;
import static com.game.utils.HelpMethod.isFloor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class Human extends Enemy{
    
    public Human(float x, float y, float speed, int width, int height, int enemyType) {
        super(x, y, speed, HUMAN_WIDTH, HUMAN_HEIGHT, HUMAN);
        subImage = new BufferedImage[9];
        animation = new BufferedImage[3][3];
        loadAnimation();
        initHitBox(x,y,(int)(24*GamePanel.scale),(int)(28*GamePanel.scale));
    }
    void loadAnimation(){
        for (int i =0; i<9;i++){
            
             try {
             subImage[i] = ImageIO.read(getClass().getResourceAsStream("/enemies/tile"+i+".png"));
         } catch (IOException ex) {
            ex.printStackTrace();
         }
        }
        
       // add animation 
      int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                animation[i][j] = subImage[k];
                k++;
            }
        }  
    }

      public void update(List<List<Integer>> level){
        updateAnimation();
        updateMove(level);
    }
    public void updateMove(List<List<Integer>> level){
        if(firstUpdate){
              firstUpdateCheck(level);
        }
          
        if (inAir){
           updateInAir(level);
        } else{
            switch(enemyState){
                case Constants.EnemyContants.IDLE -> enemyState=RUNNING_RIGHT;
                case Constants.EnemyContants.RUNNING_LEFT ->{
                    float xSpeed = 0;
                    
                    if(walkDir==LEFT) 
                        xSpeed=-walkSpeed;
                    else 
                        xSpeed=walkSpeed;
                    
                    if(CanMoveHere(hitbox.x+xSpeed,hitbox.y,hitbox.width,hitbox.height,level))
                        if(isFloor(hitbox,xSpeed+hitbox.width,level)){
                            hitbox.x+=xSpeed;
                            return;
                        }
                    changeWalkDir();
                    enemyState=RUNNING_RIGHT;
                }
                case Constants.EnemyContants.RUNNING_RIGHT ->{
                    float xSpeed = 0;
                    if(walkDir==LEFT) xSpeed=-walkSpeed;
                    else xSpeed=walkSpeed;
                    if(CanMoveHere(hitbox.x+xSpeed ,hitbox.y,hitbox.width,hitbox.height,level))
                        if(isFloor(hitbox,xSpeed,level)){
                            hitbox.x+=xSpeed;
                            return;
                        }
                    changeWalkDir();
                    enemyState=RUNNING_LEFT;
                }    
            }
        }
        
    }
    
}
