package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.http.Api
import com.example.myapplication.http.TestIp



class MainActivity : AppCompatActivity() {

    companion object {
        val t=TestIp()

    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUp = findViewById<Button>(R.id.btnUp)
        val btnleft = findViewById<Button>(R.id.btnleft)
        val btncamera = findViewById<Button>(R.id.btncamera)
        val btnright = findViewById<Button>(R.id.btnright)
        val btndown = findViewById<Button>(R.id.btndown)
        val btnstop = findViewById<Button>(R.id.btnstop)
        val btnIp = findViewById<Button>(R.id.btnIp)

        val edit_text = findViewById<EditText>(R.id.edit_text)



        val onClick = OnClick()
        btnUp.setOnClickListener(onClick)
        btnleft.setOnClickListener(onClick)
        btnstop.setOnClickListener(onClick)
        btnright.setOnClickListener(onClick)
        btndown.setOnClickListener(onClick)
        btncamera.setOnClickListener(onClick)
        btnIp.setOnClickListener {

            var inputText = edit_text.getText().toString()
            t.setTextIp(inputText)

            //Toast.makeText(this@MainActivity,"ip="+inputText+"%",Toast.LENGTH_SHORT)
        };

    }





    private class OnClick : View.OnClickListener {

//        var url = "http://192.168.100.17:8081"
        var con: String = ""
        var api: Api = Api()



        override fun onClick(v: View) {

            when (v.id) {
                R.id.btnUp -> {
                    con = "1"
                    var url=t.getTextIp()

                    System.out.println(url)
                    System.out.println(con)
                    api.sendByOKHttp(url, con)
                }
                R.id.btnleft -> {
                    con = "2"
                    var url=t.getTextIp()
                    System.out.println(url)
                    System.out.println(con)
                    api.sendByOKHttp(url, con)
                }
                R.id.btnstop -> {
                    con = "3"
                    var url=t.getTextIp()
                    System.out.println(url)
                    System.out.println(con)
                    api.sendByOKHttp(url, con)
                }
                R.id.btnright -> {
                    con = "4"
                    var url=t.getTextIp()
                    System.out.println(url)
                    System.out.println(con)
                    api.sendByOKHttp(url, con)
                }
                R.id.btndown -> {
                    con = "5"
                    var url=t.getTextIp()
                    System.out.println(url)
                    System.out.println(con)
                    api.sendByOKHttp(url, con)
                }
                R.id.btncamera -> {
                    con = "6"
                    var url=t.getTextIp()
                    System.out.println(url)
                    System.out.println(con)
                    api.sendByOKHttp(url, con)
                }
                else -> {
                }
            }


        }
    }


}