/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.game.utils;

/**
 *
 * @author ADMIN
 */
public class Constants {
    
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
}
