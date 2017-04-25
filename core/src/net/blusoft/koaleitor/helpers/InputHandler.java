package net.blusoft.koaleitor.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import net.blusoft.koaleitor.objects.Koala;
import net.blusoft.koaleitor.screens.Koaleitor;


public class InputHandler implements InputProcessor{

    Koala koala;
    Koaleitor game;

    public InputHandler(Koaleitor game){
        this.game=game;
        this.koala=game.getKoala();
    }

    @Override
    public boolean keyDown(int keycode) {
        if ((Gdx.input.isKeyPressed(Input.Keys.SPACE) || isTouched(0.5f, 1)) && koala.grounded &&koala.velocity.y>=0) {
            koala.velocity.y += Koala.JUMP_VELOCITY;
            koala.state = Koala.State.Jumping;
            koala.grounded = false;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A) || isTouched(0, 0.25f)) {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                Gdx.app.log("superkoaleitor", "hyperspace");
                koala.velocity.x = -Koala.MAX_VELOCITY*2;
            }
            else {
                koala.velocity.x = -Koala.MAX_VELOCITY;
            }
            if (koala.grounded) koala.state = Koala.State.Walking;
            koala.facesRight = false;
            System.out.println("LEFT!");
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D) || isTouched(0.25f, 0.5f)) {
            if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
                Gdx.app.log("superkoaleitor", "hyperspace");
                koala.velocity.x = Koala.MAX_VELOCITY*2;
            }
            else {
                koala.velocity.x = Koala.MAX_VELOCITY;
            }
            if (koala.grounded) {
                koala.state = Koala.State.Walking;
            }
            koala.facesRight = true;
            System.out.println("RIGHT");
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.B)){
            game.debug = !game.debug;}


        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if ((keycode ==Input.Keys.RIGHT) || keycode ==(Input.Keys.D) || (keycode ==Input.Keys.LEFT) || keycode ==(Input.Keys.A)) {

            koala.velocity.x = 0;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private boolean isTouched (float startX, float endX) {
        // Check for touch inputs between startX and endX
        // startX/endX are given between 0 (left edge of the screen) and 1 (right edge of the screen)
        for (int i = 0; i < 2; i++) {
            float x = Gdx.input.getX(i) / (float)Gdx.graphics.getWidth();
            if (Gdx.input.isTouched(i) && (x >= startX && x <= endX)) {
                return true;
            }
        }
        return false;
    }
}
