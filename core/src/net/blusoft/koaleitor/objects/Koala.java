package net.blusoft.koaleitor.objects;

import com.badlogic.gdx.math.Vector2;


public class Koala {


        public static float WIDTH;
        public static float HEIGHT;
        public static float MAX_VELOCITY = 10f;
        public static float JUMP_VELOCITY = 40f;
        public static float DAMPING = 0.87f;

        public enum State {
            Standing, Walking, Jumping
        }

        public final Vector2 position = new Vector2();
        public final Vector2 velocity = new Vector2();
        public Koala.State state = Koala.State.Walking;
        public float stateTime = 0;
        public boolean facesRight = true;
        public boolean grounded = false;


}
