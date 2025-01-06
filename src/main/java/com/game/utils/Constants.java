/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.utils;

import com.game.main.GamePanel;

/**
 *
 * @author ADMIN
 */
public class Constants {
    
    
    public static class Enviroment{
         public static final int CLOUD_WIDTH_DEFAULT = 52;
          public static final int CLOUD_HEIGHT_DEFAULT = 40;
         public static final int CLOUD_HEIGHT = (int)(CLOUD_HEIGHT_DEFAULT*GamePanel.scale);
         public static final int CLOUD_WIDTH = (int)(CLOUD_WIDTH_DEFAULT*GamePanel.scale);
    }
     public static class UI{
          public static class Button{
           public static final int WIDTH_DEFAULT = 140;
           public static final int HEIGHT_DEFAULT = 60;
           public static final int BUTTON_WIDTH = (int)(WIDTH_DEFAULT*GamePanel.scale);
           public static final int BUTTON_HEIGHT = (int)(HEIGHT_DEFAULT*GamePanel.scale);
     }
           public static class PauseButton{
           public static final int SOUND_SIZE_DEFAULT = 42;
            public static final int SOUND_SIZE = (int)(SOUND_SIZE_DEFAULT*GamePanel.scale);
     }
           public static class URMButton{
            public static final int URM_SIZE_DEFAULT = 50;
            public static final int URM_SIZE = (int)(URM_SIZE_DEFAULT*GamePanel.scale);
     }
           public static class VolumeButton{
            public static final int VOLUME_WIDTH_DEFAULT = 28;
            public static final int VOLUME_HEIGHT_DEFAULT = 45;
             
            public static final int SLIDER_WIDTH_DEFAULT = 215;
            public static final int SLIDER_WIDTH = (int)(SLIDER_WIDTH_DEFAULT*GamePanel.scale);
             
            public static final int VOLUME_WIDTH = (int)(VOLUME_WIDTH_DEFAULT*GamePanel.scale);
            public static final int VOLUME_HEIGHT = (int)(VOLUME_HEIGHT_DEFAULT*GamePanel.scale);
            
     }
    }
    
    public static class Direction{
          public static final int UP = 0;
          public static final int DOWN = 1;
          public static final int LEFT = 2;
          public static final int RIGHT = 3;
    }
    
    
    public static class PlayerContants{
        
        //index cua action [index][] trong animation
        //return ve so luong animation cua action do
        public static final int IDLE = 4;
        public static final int FALLING = 0;
        public static final int JUMPING_lEFT = 5;
        public static final int JUMPING_RIGHT = 1;
        public static final int RUNNING_LEFT = 6;
        public static final int RUNNING_RIGHT = 2;
        
        // lay so luong animation
        public static int getSpriteAmount(int action){
            switch(action){
                case IDLE -> {
                    return 3;
                 }
                case RUNNING_LEFT -> {
                    return 3;
                 }
                case RUNNING_RIGHT -> {
                    return 3;
                 }
                case JUMPING_lEFT -> {
                    return 3;
                 }
                  case JUMPING_RIGHT -> {
                    return 3;
                 }case FALLING -> {
                    return 3;
                 }
                default -> {
                    return 1;
                }
            }
                   
        }
    }
     public static class EnemyContants{
          public static final int HUMAN = 0;
          
          public static final int IDLE = 0;
          public static final int RUNNING_LEFT = 1;
          public static final int RUNNING_RIGHT = 2;
          
            
        public static final int HUMAN_WIDTH_DF = 30;
        public static final int HUMAN_HEIGHT_DF = 30;
        public static final int HUMAN_WIDTH = (int)(HUMAN_WIDTH_DF*GamePanel.scale);
        public static final int HUMAN_HEIGHT = (int)(HUMAN_HEIGHT_DF*GamePanel.scale);
        
        public static final int HUMAN_DRAWOFFSET_X = (int)(28*GamePanel.scale);
        public static final int HUMAN_DRAWOFFSET_Y = (int)(9*GamePanel.scale);
        
         public static int getSpriteAmount(int enemyType, int enemyState){
             switch(enemyType){
                 case HUMAN ->  {
                     {
                         switch(enemyState){
                            case IDLE -> {
                                 return 3;
                                            }
                            case RUNNING_LEFT -> {
                                return 3;
                                                 }
                            case RUNNING_RIGHT -> {
                            return 3;
                                                    }
                           default -> {
                                return 1;
                                        }
                         }
                     }
                 
             }  default -> {
                    return 1;
                }
             }
         }
        
     }
}
