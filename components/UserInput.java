package com.mygdx.game.components;


import com.mygdx.game.entities.Entity;

public class UserInput implements Component
{
    public static int inputOwner;
    public UserInput(Entity user){
        inputOwner =user.ID;
    }

}