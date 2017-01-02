package com.epicness.game.organizers;

import com.badlogic.gdx.Gdx;

/**
 * Created by Groxar on 11/11/2016.
 * Esta clase nos sirve para almacenar medidas útiles y se puedan
 * acceder desde cualquier otra clase
 */

public class Metrics {

    public static final int phoneWidth = Gdx.graphics.getWidth();
    public static final int phoneHeight = Gdx.graphics.getHeight();
    public static final float tabHeight = phoneHeight - phoneHeight / 12;

}
