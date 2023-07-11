package haodtph27524.fpoly.lab2.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import haodtph27524.fpoly.lab2.R;
import haodtph27524.fpoly.lab2.bai2.BackgroundTask_POST;

public class MainBai3 extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.1.3:80/haodt_ph27524/thetich_post.php";

    private EditText edCanh;
    private Button btnSend,btnBack;
    private TextView tvResult;
    String strCanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai3);
        edCanh = (EditText) findViewById(R.id.ed_canh);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnBack = (Button) findViewById(R.id.btn_back);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnSend.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                strCanh = edCanh.getText().toString();
                Bai3_POST bai3_post = new Bai3_POST(tvResult,this);
                bai3_post.execute(strCanh);
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }
}