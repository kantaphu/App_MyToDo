package com.example.mytodo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytodo.model.Auth;

public class LoginActivity extends AppCompatActivity /*//V.2 implements View.OnClickListener*/ {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText emailEditText = findViewById(R.id.emailedit);
                EditText passwordEditText = findViewById(R.id.passwordedit);

                CheckBox rememberPasswordCheckBox = findViewById(R.id.remember_password_checkbox);

                if(rememberPasswordCheckBox.isChecked())
                {
                    Toast.makeText(
                            LoginActivity.this,
                            "คุณเลือกจำรหัสผ่าน",
                            Toast.LENGTH_SHORT
                    ).show();
                }
                else
                {
                    Toast.makeText(
                            LoginActivity.this,
                            "คุณไม่ได้เลือกจำรหัสผ่าน",
                            Toast.LENGTH_SHORT
                    ).show();
                }

                String inputEmail = emailEditText.getText().toString();
                String inputPassword = passwordEditText.getText().toString();

                Auth auth = new Auth(inputEmail, inputPassword);
                /*auth.setEmail(inputEmail);
                auth.setPassword(inputPassword);*/

                boolean result = auth.check();

                if (result) {
                    Toast.makeText(
                            LoginActivity.this,
                            R.string.Login_success,
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage(R.string.Login_failed);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //โค้ดที่ให้ทำงาน เมื่อ user กดปุ่ม ok
                            //todo;
                        }
                    });
                    /*dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //โค้ดที่ให้ทำงานเมื่อ user กดปุ่ม Cancel
                            //todo;
                        }
                    });
                    dialog.setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //โค้ดที่ให้ทำงานเมื่อ user กดปุ่ม Ignore
                            //todo;
                        }
                    });*/
                    dialog.show();
                }
            }
        });

        /*V.1//ใช้ตัวแปรอ้างอิงปุ่มไปยัง layout
        Button loginButton = findViewById(R.id.login_button); //เรียกปุ่มมาละ ต่อจากนี้ก็กำหนดคำสั่งต่อไปได้
        //สร้าง listener จากคลาส MyListener
        MyListener listener = new MyListener();
        //ผูกปุ่มกับ listener เข้าด้วยกัน
        loginButton.setOnClickListener(listener);*/

        /*//v.2
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);*/

        /*//V.3
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t = Toast.makeText(LoginActivity.this,"Hello" , Toast.LENGTH_SHORT);
                t.show();
            }
        });*/

        /*//V.4
        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this,"Hello" , Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    //V.1
    /*private class MyListener implements View.OnClickListener { //ลองเปลี่ยนเป็น OnLongClick ก็ได้
        @Override
        public void onClick(View view) {
            Toast t = Toast.makeText(LoginActivity.this,"Hello" , Toast.LENGTH_SHORT);
            t.show();
        }
    }*/

    /*//V.2
    @Override
    public void onClick(View v) {
        Toast t = Toast.makeText(LoginActivity.this,"Hello" , Toast.LENGTH_SHORT);
        t.show();
    }*/
}
