package haodtph27524.fpoly.lab2.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import haodtph27524.fpoly.lab2.R;

public class MainBai1 extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.1.9:80/haodt_ph27524/student_get.php";
    private EditText edName;
    private EditText edScore;
    private Button btnSend;
    private TextView tvResult;
    private Button btnBack;


    String strName,strScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai1);
        edName = (EditText) findViewById(R.id.ed_name);
        edScore = (EditText) findViewById(R.id.ed_score);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnBack = (Button) findViewById(R.id.btn_back);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnBack.setOnClickListener(this);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                strName = edName.getText().toString().trim();
                strScore = edScore.getText().toString().trim();
                BackgroundTask_GET backgroundTask = new BackgroundTask_GET(tvResult,strName,strScore,this);
                backgroundTask.execute();
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }
}