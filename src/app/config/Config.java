package app.config;

import app.config.interfaces.ConfigInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config implements ConfigInterface {

    private static Config _instance = null;
    private static Properties props;

    private Config(){

    }

    public static Config getInstance(){
        if(_instance == null)
            _instance = new Config();
        return _instance;
    }

    public void load() {
        try {
            FileReader reader = new FileReader("config.properties");
            props = new Properties();
            props.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            // Do sth please
        } catch (IOException e){
            // Do sth please
        }
    }

    public Properties getProps(){
        return props;
    }

    public String getProperty(String key){
        return getProps().getProperty(key);
    }
}
