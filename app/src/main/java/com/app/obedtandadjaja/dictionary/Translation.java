package com.app.obedtandadjaja.dictionary;

/**
 * Created by obedtandadjaja on 8/26/15.
 */
public class Translation {

    private String word;
    private String translation;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Translation(String word, String translation)
    {
        this.word = word;
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
