package com.example.atteandancesystem;

import android.app.Application;

public class gloabaldata extends Application {

    String uname,cat;

    void setuname(String uname)
    {
        this.uname=uname;
    }

    String getuname()
    {
        return  uname;
    }

    void setcat(String cat)
    {
        cat=this.cat;
    }
    String getCat()
    {
        return  cat;
    }

}
