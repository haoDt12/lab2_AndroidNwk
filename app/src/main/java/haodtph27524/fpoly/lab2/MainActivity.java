package haodtph27524.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import haodtph27524.fpoly.lab2.bai1.MainBai1;
import haodtph27524.fpoly.lab2.bai2.MainBai2;
import haodtph27524.fpoly.lab2.bai3.MainBai3;
import haodtph27524.fpoly.lab2.bai4.MainBai4;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBai1;
    private Button btnBai2;
    private Button btnBai3;
    private Button btnBai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBai1 = (Button) findViewById(R.id.btn_bai1);
        btnBai2 = (Button) findViewById(R.id.btn_bai2);
        btnBai3 = (Button) findViewById(R.id.btn_bai3);
        btnBai4 = (Button) findViewById(R.id.btn_bai4);
        btnBai1.setOnClickListener(this);
        btnBai2.setOnClickListener(this);
        btnBai3.setOnClickListener(this);
        btnBai4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bai1:
                startActivity(new Intent(MainActivity.this, MainBai1.class));
                break;
            case R.id.btn_bai2:
                startActivity(new Intent(MainActivity.this, MainBai2.class));
                break;
            case R.id.btn_bai3:
                startActivity(new Intent(MainActivity.this, MainBai3.class));
                break;
            case R.id.btn_bai4:
                startActivity(new Intent(MainActivity.this, MainBai4.class));
                break;
        }
    }
}