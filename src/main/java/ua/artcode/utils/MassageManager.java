package ua.artcode.utils;

import org.springframework.stereotype.Service;

import java.util.ResourceBundle;

/**
 * Created by andrey on 25.03.15.
 */
@Service
public class MassageManager {

    ResourceBundle bandle = ResourceBundle.getBundle("massage");

    public MassageManager() {
    }

    public String getMassage(String name){
        return bandle.getString(name);
    }
}
