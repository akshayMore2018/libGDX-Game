package com.mygdx.game.components;

import com.mygdx.game.physicsAndUtils.Vector7;


public class Motion implements Component
{
    public Vector7 velocity;
    public Motion(float velX,float velY){
        velocity=new Vector7(velX,velY);
    }

    @Override
    public String toString()
    {
        return "("+velocity.x+","+velocity.y+")";
    }
}