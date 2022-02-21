package com.cahrusat.onetimelogindiviii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var user:TextInputEditText=findViewById(R.id.edtUname)
        var pass:TextInputEditText=findViewById(R.id.edtPass)
        var submit:Button=findViewById(R.id.btnSubmit)
        var cancel:Button=findViewById(R.id.btnCancel)
        submit.setOnClickListener {
            var username=user.text.toString()
            var password=pass.text.toString()
            if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
            {
                Toast.makeText(applicationContext,
                    "Please Enter UserName/Password",
                    Toast.LENGTH_LONG).show()
            }
            else{
                if(username.equals("admin") && password.equals("admin"))
                {

                    var preference=getSharedPreferences("MyPref", MODE_PRIVATE)
                    var editor=preference.edit()
                    editor.putString("user",username)
                    editor.commit()

                    var intent=Intent(applicationContext,WelcomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                {
                    Toast.makeText(applicationContext,
                        "Invalid UserName/Password",
                        Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}