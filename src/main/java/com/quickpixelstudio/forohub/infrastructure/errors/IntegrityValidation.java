package com.quickpixelstudio.forohub.infrastructure.errors;

public class IntegrityValidation extends RuntimeException{
    public IntegrityValidation(String s){
        super(s);
    }
}