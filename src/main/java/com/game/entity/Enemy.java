/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.entity;

import com.game.main.GamePanel;
import static com.game.utils.Constants.Direction.*;
import com.game.utils.Constants.EnemyContants;
import static com.game.utils.Constants.EnemyContants.*;
import static com.game.utils.Constants.PlayerContants.getSpriteAmount;
import static com.game.utils.HelpMethod.*;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Enemy extends Entity {
    
    
    public int animationIndex, enemyState,enemyType;
   public int animationTick=0, animationSpeed=20;
    
   public boolean firstUpdate = true;
   public boolean inAir=false;
   public float fallSpeed;
   public float gravity = 0.04f*GamePanel.scale;
   public float walkSpeed = speed;
   public int walkDir = LEFT;
    
    public Enemy(float x, float y, float speed, int width, int height,int enemyType ) {
        super(x, y, speed, width, height);
        this.enemyType=enemyType;
        initHitBox(x,y,width,height);
    }
    public void updateAnimation(){
           animationTick++;
           if(animationTick >=animationSpeed){
            animationTick=0;
            animationIndex++;
            if(animationIndex>=EnemyContants.getSpriteAmount(enemyType,enemyState)){
                animationIndex=0;
            }
           }
       }
    
    public void firstUpdateCheck(List<List<Integer>> level){
        if(!IsEntityOnFloor(hitbox,level))
                inAir = true;
                firstUpdate=false;
    }
    public void updateInAir(List<List<Integer>> level){
         if(CanMoveHere(hitbox.x,hitbox.y+fallSpeed,hitbox.width,hitbox.height,level)){
                hitbox.y+=fallSpeed;
                fallSpeed+=gravity;
            }
            else{
            inAir = false;
            hitbox.y=GetEntityYPosUnderRoofOrAboveFloor(hitbox,fallSpeed);
            }  
    }
    public void changeWalkDir(){
        if(walkDir==LEFT)
               walkDir = RIGHT;
        else
            walkDir=LEFT;
    }
    public void newState(int state){
        this.enemyState=state;
        animationIndex=0;
        animationTick=0;
        
    }
    public int getAnimationIndex() {
        return animationIndex;
    }

    public void setAnimationIndex(int animationIndex) {
        this.animationIndex = animationIndex;
    }

    public int getEnemyState() {
        return enemyState;
    }

    public void setEnemyState(int enemyState) {
        this.enemyState = enemyState;
    }
}
