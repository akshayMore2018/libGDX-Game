package com.mygdx.game.components;

import com.mygdx.game.physicsAndUtils.Vector7;


public class Position implements Component
{

    public Vector7 position;

    public Position(float posX, float posY)
    {
        position = new Vector7(posX, posY);
    }

    @Override
    public String toString()
    {
        return "(" + position.x + "," + position.y + ")";
    }
}