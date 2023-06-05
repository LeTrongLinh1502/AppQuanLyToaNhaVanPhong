package com.example.testdb.database;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection connection;
    String ip,port,db,un,pass;

    @SuppressLint("NewApi")
    public Connection conclass(){
        ip="10.21.57.199";
        port="1433";
        db="QuanLyToaNhaVanPhong";
        un="lelinh";
        pass="01012001";
        StrictMode.ThreadPolicy tpolicy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tpolicy);
        Connection con =null;
        String ConnectionURL=null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL= "jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databaseName="+ db+ ";user="+un+";password="+pass+";";
            con= DriverManager.getConnection(ConnectionURL);
        }
        catch (Exception ex)
        {
            Log.e("Error : ", ex.getMessage());
        }
        return con;
    }
}
