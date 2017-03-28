package com.example.nson.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnDialog;
    private Button btnAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDialog= (Button)findViewById(R.id.btnDialog);
        btnAlertDialog= (Button)findViewById(R.id.btnAlertDialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            //    ShowAlertDialog();
            }
            private void showDialog() {
                final Dialog dialog= new Dialog(MainActivity.this);
                dialog.setTitle("ThangCoder.com");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_layout);
                Button btnDangXuat= (Button)dialog.findViewById(R.id.btnDangXuat);
                Button btnHuy= (Button)dialog.findViewById(R.id.btnHuy);

                btnDangXuat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng xuất thành công!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private void ShowAlertDialog() {
        AlertDialog.Builder buider= new AlertDialog.Builder(MainActivity.this);
        buider.setTitle("ThangCoder.com");
        buider.setMessage("Do you want to Logout?");
        buider.setCancelable(false);
        buider.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Logout is successful", Toast.LENGTH_SHORT).show();
            }
        });
        buider.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert= buider.create();
        alert.show();
    }
}
