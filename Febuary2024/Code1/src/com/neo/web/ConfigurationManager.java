package com.neo.web;

public class ConfigurationManager {

    //SINGLETON DESIGN PATTERN

    private static ConfigurationManager instance;

    private ConfigurationManager(){}


    public static ConfigurationManager getInstance(){
        if(instance == null){
            instance = new ConfigurationManager();
        }
        return instance;
    }
}
