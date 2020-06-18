package com.ocescalade.model;


public class Search {
    private String mot;

    
    //Constructors
    public Search() {
    	this("");
    }
    
    
    public Search(String string) {
		this.mot=string;
	}


	//Getters and Setters
    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }
}