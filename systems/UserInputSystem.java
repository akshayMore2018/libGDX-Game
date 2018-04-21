package com.mygdx.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.components.Motion;
import com.mygdx.game.components.UserInput;
import com.mygdx.game.entities.EntityManager;

public class UserInputSystem implements Systems {
    private EntityManager em;
    public UserInputSystem(){
        em = EntityManager.getInstance();
    }


    public void Update(){

            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                em.getComponent(UserInput.inputOwner, Motion.class).velocity.x=-1;
            }
            else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
                em.getComponent(UserInput.inputOwner, Motion.class).velocity.x=1;
            }
            else if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                em.getComponent(UserInput.inputOwner, Motion.class).velocity.y=1;
            }
            else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                em.getComponent(UserInput.inputOwner, Motion.class).velocity.y=-1;
            }
            else{
                em.getComponent(UserInput.inputOwner, Motion.class).velocity.y=0;
                em.getComponent(UserInput.inputOwner, Motion.class).velocity.x=0;
            }


    }
}
