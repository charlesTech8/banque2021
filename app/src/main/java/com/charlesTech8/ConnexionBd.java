package com.charlesTech8;

public class ConnexionBd {

    String connst = "http://192.168.200.149/banque2021/";

    public ConnexionBd() {
    }
    String valCon( String typeCon ){
        return connst+typeCon;
    }
}
