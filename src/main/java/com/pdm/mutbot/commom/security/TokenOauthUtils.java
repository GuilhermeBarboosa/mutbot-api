package com.pdm.mutbot.commom.security;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TokenOauthUtils {


    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
