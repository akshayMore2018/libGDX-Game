package com.mygdx.game.systems;


import com.badlogic.gdx.Gdx;
import com.mygdx.game.Settings;
import com.mygdx.game.components.Camera;
import com.mygdx.game.components.Position;
import com.mygdx.game.components.UserInput;
import com.mygdx.game.entities.EntityManager;

public class CameraSystem {
    private EntityManager em;
    public CameraSystem() {
        em = EntityManager.getInstance();
    }

    public void update() {
        float camOwnerX= (float) (em.getComponent(Camera.cameraOwner, Position.class).position.x+0.5f);
        float camOwnerY= (float) (em.getComponent(Camera.cameraOwner, Position.class).position.y+0.5f);

        em.getComponent(Camera.cameraOwner,Camera.class).worldStart.x=Gdx.graphics.getWidth()/2-camOwnerX* Settings.SCALED_TILE_SIZE;
        em.getComponent(Camera.cameraOwner,Camera.class).worldStart.y=Gdx.graphics.getHeight()/2-camOwnerY*Settings.SCALED_TILE_SIZE;

    }
}
