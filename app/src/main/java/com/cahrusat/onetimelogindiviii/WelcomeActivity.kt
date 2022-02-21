package com.cahrusat.onetimelogindiviii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        var txtUser:TextView=findViewById(R.id.txtUser)
        var preference=getSharedPreferences("MyPref", MODE_PRIVATE)
        var str=preference.getString("user","wrong")
        txtUser.append(str)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId
        if(id==R.id.item1)
        {
            var preference=getSharedPreferences("MyPref", MODE_PRIVATE)
            var editor=preference.edit()
            editor.clear()
            editor.commit()
            var intent=Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext,"Logout Successfully",
                Toast.LENGTH_LONG).show()
        }
        else if(id==R.id.item2)
        {
            Toast.makeText(applicationContext,"Item2",
                Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}