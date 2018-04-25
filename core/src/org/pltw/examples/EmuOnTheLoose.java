/*package org.pltw.examples;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.pltw.examples.game.Assets;
import org.pltw.examples.game.WorldController;
import org.pltw.examples.game.WorldModel;
import org.pltw.examples.game.WorldView;

public class EmuOnTheLoose extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

}*/
// This is the original code in this class that was replaced with the code in 4.1.1.17
package org.pltw.examples;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

import org.pltw.examples.game.Assets;
import org.pltw.examples.game.WorldController;
import org.pltw.examples.game.WorldModel;
import org.pltw.examples.game.WorldView;

public class EmuOnTheLoose implements ApplicationListener {

    private static final String TAG = EmuOnTheLoose.class.getName();

    private WorldController worldController;
    private WorldView worldView;
    private WorldModel worldModel;

    private boolean paused;

    @Override
    public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Assets.instance.init(new AssetManager());
        worldController = new WorldController();
        worldModel = new WorldModel();
        worldView = new WorldView(worldController, worldModel);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0x95 / 255.0f, 0x95 / 255.0f, 0x95 / 255.0f, 0xff / 255.0f); //grey
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen
        worldView.render();
    }

    @Override
    public void resize (int width, int height) {
        worldView.resize(width, height);
    }

    @Override
    public void pause () {
        paused = true;
    }

    @Override
    public void resume () {
        paused = false;
    }

    @Override
    public void dispose () {
        worldView.dispose();
        Assets.instance.dispose();
    }

}

