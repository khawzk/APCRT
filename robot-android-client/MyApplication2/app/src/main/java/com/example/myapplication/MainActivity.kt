package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.http.Api
import com.example.myapplication.http.TestIp
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import org.jetbrains.anko.alert
import java.io.IOException


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
        val btnmap = findViewById<Button>(R.id.btnmap)
        val btnmanual = findViewById<Button>(R.id.btnmanual)
        val btnAutopilot = findViewById<Button>(R.id.btnAutopilot)

        val edit_text = findViewById<EditText>(R.id.edit_text)

        val tv_alert = findViewById<TextView>(R.id.tv_alert)
        val iv_scale = findViewById<ImageView>(R.id.iv_scale)

        val onClick = OnClick()
        btnUp.setOnClickListener(onClick)
        btnleft.setOnClickListener(onClick)
        btnstop.setOnClickListener(onClick)
        btnright.setOnClickListener(onClick)
        btndown.setOnClickListener(onClick)
        btncamera.setOnClickListener(onClick)
        btnAutopilot.setOnClickListener(onClick)
        btnmap.setOnClickListener(onClick)
        btnIp.setOnClickListener {

            var inputText = edit_text.getText().toString()
            //Toast.makeText(this@MainActivity,"ip="+inputText+"%",Toast.LENGTH_SHORT)
            alert("Are you sure you want to enter the IP？", "respected user") {
                positiveButton("Sure") {
                    tv_alert.text ="IP entered"
                    t.setTextIp(inputText)
                }
                negativeButton("Cancel") {
                    tv_alert.text = "IP cancel input"
                }
            }.show()

        };
        btnmap.setOnClickListener {

            //Toast.makeText(this@MainActivity,"ip="+inputText+"%",Toast.LENGTH_SHORT)
            alert("update the map？", "respected user") {
                positiveButton("sure") {
                    iv_scale.setImageResource(R.drawable.ha)
                    tv_alert.text ="map updated"
                }
                negativeButton("Cancel") {
                    tv_alert.text = "Update map canceled"
                }
            }.show()

        };
        btnmanual.setOnClickListener {

            //Toast.makeText(this@MainActivity,"ip="+inputText+"%",Toast.LENGTH_SHORT)
            alert("Are you sure you want to switch to manual mode？", "respected user") {
                positiveButton("sure") {
                    tv_alert.text ="Manual mode switched"
                }
                negativeButton("Cancel") {
                    tv_alert.text = "Cancelled"
                }
            }.show()

        };
        btnAutopilot.setOnClickListener {
            tv_alert.text = "autopilot"
            var con: String = ""
            var api: Api = Api()
            con = "7"
            var url=t.getTextIp() + "/zigzag"

            val callback = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    tv_alert.text = "end of autopilot"
                    alert("end of autopilot", "respected user") {
                        positiveButton("sure") {
                            tv_alert.text ="reach the destination"
                        }
                        negativeButton("Cancel") {
                            tv_alert.text = "Cancel"
                        }
                    }.show()
                }

                override fun onResponse(call: Call, response: Response) {
                    tv_alert.text = "end of autopilot"
                    alert("end of autopilot", "respected user") {
                        positiveButton("sure") {
                            tv_alert.text ="reach the destination"
                        }
                        negativeButton("Cancel") {
                            tv_alert.text = "Cancel"
                        }
                    }.show()
                }
            }


            api.asyncSendGetRequest(url, con, callback);
            // 开始时间stopWatch.start()
            // 执行时间(1s)


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
                    var url=t.getTextIp() + "/manual/forward"

                    api.sendGetRequest(url, con)
                    //makeText(this@MainActivity, "score=+", LENGTH_SHORT).show()

                }
                R.id.btnleft -> {
                    con = "2"
                    var url=t.getTextIp() + "/manual/left"
                    api.sendGetRequest(url, con)
                }
                R.id.btnstop -> {
                    con = "3"
                    var url=t.getTextIp() + "/manual/stop"
                    api.sendGetRequest(url, con)
                }
                R.id.btnright -> {
                    con = "4"
                    var url=t.getTextIp() + "/manual/right"
                    api.sendGetRequest(url, con)
                }
                R.id.btndown -> {
                    con = "5"
                    var url=t.getTextIp() + "/manual/backward"
                    api.sendGetRequest(url, con)
                }
                R.id.btncamera -> {
                    con = "6"
                    var url=t.getTextIp() + "/squareleft"
                    api.sendGetRequest(url, con)
                }
                else -> {
                }
            }


        }
    }


}