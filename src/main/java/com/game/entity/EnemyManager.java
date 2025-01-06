/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.entity;

import com.game.level.Level;
import com.game.state.Playing;
import static com.game.utils.Constants.EnemyContants.*;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class EnemyManager {
    public Playing playing;
    public List<Human> humans = new ArrayList<>();
    public Level level;
    
    public EnemyManager(Playing playing) {
        this.playing = playing;
        Human human1 = new Human((float)100,(float)435,1,(int)HUMAN_WIDTH,(int)HUMAN_HEIGHT,0); 
        Human human2 = new Human((float)800,(float)435,1,(int)HUMAN_WIDTH,(int)HUMAN_HEIGHT,0); 
        humans.add(human1);
        humans.add(human2);
        level =playing.tileManager.level1;
    }
    public void update(){
        for(Human human : humans){
            human.update(level.tileMatrix);
        }
        
    }
    public void draw(Graphics2D g2,int xLvlOffSet){
        drawHuman(g2,xLvlOffSet);
    }
    public void drawHuman(Graphics2D g2,int xLvlOffSet){
        for(Human human : humans){
            g2.drawImage(human.animation[human.enemyState][human.animationIndex],(int)human.hitbox.x-xLvlOffSet,(int)human.hitbox.y,human.width,human.height,null);
            human.drawHitBox(g2, xLvlOffSet);
        }
    }
    
}
