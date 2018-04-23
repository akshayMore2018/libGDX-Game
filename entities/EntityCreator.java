package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.mygdx.game.systems.CameraSystem;
import com.mygdx.game.systems.CollisionSystem;
import com.mygdx.game.systems.MotionSystem;
import com.mygdx.game.systems.RenderSystem;
import com.mygdx.game.systems.UserInputSystem;
import com.mygdx.game.world.TileMap;

import java.util.ArrayList;

public class EntityCreator
{
    private RenderSystem rend;
    private MotionSystem motion;
    private UserInputSystem command;
    private CollisionSystem collisionCheck;
    private CameraSystem camera;

    public EntityCreator(TileMap map)
    {
        ArrayList<Entity> entityList = new ArrayList<Entity>();
        entityList.add(new Player(map));
        entityList.add(new Zombie(map));
        rend = new RenderSystem(entityList,map);
        motion = new MotionSystem(entityList);
        command=new UserInputSystem();
        collisionCheck=new CollisionSystem(entityList,map);
        camera=new CameraSystem();
    }

    public void update()
    {
        collisionCheck.update();
        motion.update();
        camera.update();
        command.Update();
    }


    public void sketch(PolygonSpriteBatch batch)
    {
        rend.sketch(batch);
    }

}
