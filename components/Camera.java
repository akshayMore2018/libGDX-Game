package com.mygdx.game.components;

import com.mygdx.game.entities.Entity;
import com.mygdx.game.physicsAndUtils.Vector7;

public class Camera implements Component {
    public static int cameraOwner;
    public Vector7 cameraPos;
    public Camera(Entity user,float x,float y){
        cameraOwner =user.ID;
        cameraPos=new Vector7(x,y);
    }
}
