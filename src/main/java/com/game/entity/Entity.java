/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author ADMIN
 */
public abstract class Entity {
    protected float x,y;
    protected float speed;
    protected int width,height;
    protected Rectangle2D.Float hitbox;
    
    
    BufferedImage[] subImage;
    BufferedImage[][] animation;
    public Entity(float x, float y,float speed,int width,int height){
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.width=width;
        this.height=height;
    }
     protected void drawHitBox(Graphics2D g2){
       g2.setColor(Color.RED);
       g2.drawRect((int)hitbox.x, (int)hitbox.y,(int) hitbox.width, (int)hitbox.height);
    }
    protected void initHitBox(float x, float y,float width,float height){
        hitbox = new Rectangle2D.Float(x,y,width,height);
    }
//    protected void updateHitBox(){
//        hitbox.x=(int)x;
//        hitbox.y=(int)y;
//        
//    }
     public Rectangle2D.Float getHitBox(){
         return hitbox;
     }
    
}
