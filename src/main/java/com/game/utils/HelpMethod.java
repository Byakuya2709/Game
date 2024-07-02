/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.utils;

import com.game.main.GamePanel;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HelpMethod {
    public static boolean CanMoveHere(float x, float y, float width , float height,List<List<Integer>> level){
        if (isSolid(x, y, level)) return false;
        if (isSolid(x + width, y, level)) return false;
        if (isSolid(x, y + height, level)) return false;
        if (isSolid(x + width, y + height, level)) return false;

        return true;
    }
    private static boolean isSolid(float x, float y,List<List<Integer>> level){
        if (x < 0 || x >= GamePanel.width) 
            return true;
        if (y < 0 || y >= GamePanel.height)
            return true;
         
        int xIndex = (int) (x / GamePanel.tileSize);
        int yIndex = (int) (y / GamePanel.tileSize);

        // Kiểm tra nếu chỉ số nằm ngoài giới hạn của mảng level
        if (xIndex < 0 || xIndex >= level.get(0).size() || yIndex < 0 || yIndex >=level.size() ){         
               return true;
        } 
         
            

        // Lấy giá trị của ô tại chỉ số (xIndex, yIndex)
            int value = level.get(yIndex).get(xIndex);
                if(value > 0 && value <5)
            return true;
        //
        return false;
    }
    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed){
        int currentTile = (int)(hitbox.x/GamePanel.tileSize);
        if(xSpeed >0){
            //right
            int tileXPos = currentTile*GamePanel.tileSize;
            int xOffset=(int)(GamePanel.tileSize -hitbox.width);
            return tileXPos+xOffset-1;
        }else{
            //left
            return currentTile*GamePanel.tileSize;
        }
    }
    public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed){
        int currentTile = (int)(hitbox.y/GamePanel.tileSize);
        if(airSpeed >0){
            //falling
            int tileYPos = currentTile*GamePanel.tileSize;
            int yOffset=(int)(GamePanel.tileSize -hitbox.height);
            return tileYPos+yOffset-1;
        }else{
           //jummping;
            return currentTile*GamePanel.tileSize;
        }
    }
    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox,List<List<Integer>> level){
        if(!isSolid(hitbox.x,hitbox.y+hitbox.height,level)){
            if(!isSolid(hitbox.x+hitbox.width,hitbox.y+hitbox.height+1,level))
                return false;
        }
        return true;
    }
}
