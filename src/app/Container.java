package app;

import app.config.Config;
import app.config.ConfigInterface;
import app.entities.OptionsEntity;
import app.loaders.map.MapLoader;
import app.loaders.map.MapLoaderInterface;
import app.loaders.texture.TextureLoader;
import app.loaders.texture.TextureLoaderInterface;

public class Container {

    private static Container instance;

    private ConfigInterface config;
    private OptionsEntity options;
    private TextureLoaderInterface textureLoader;
    private MapLoaderInterface mapLoader;

    private Container(){}

    public static Container getInstance(){
        if(instance == null)
            instance = new Container();
        return instance;
    }

    public ConfigInterface provideConfig(){
        if(config == null){
            config = new Config();
            config.load();
        }
        return config;
    }

    public OptionsEntity provideOptions(){
        if(options == null)
            options = new OptionsEntity();
        return options;
    }

    public TextureLoaderInterface provideTextureLoader(){
        if(textureLoader == null) {
            textureLoader = new TextureLoader(provideConfig());
            textureLoader.load();
        }
        return textureLoader;
    }

    public MapLoaderInterface provideMapLoader(){
        if(mapLoader == null) {
            mapLoader = new MapLoader(provideConfig(), provideTextureLoader());
            mapLoader.load();
        }
        return mapLoader;
    }


}
