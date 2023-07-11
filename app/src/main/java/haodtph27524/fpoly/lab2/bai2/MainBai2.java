package haodtph27524.fpoly.lab2.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import haodtph27524.fpoly.lab2.R;
import haodtph27524.fpoly.lab2.bai1.BackgroundTask_GET;

public class MainBai2 extends AppCompatActivity implements View.OnClickListener {
   public static final String SERVER_NAME = "http://192.168.1.3:80/haodt_ph27524/rectangle_post.php";
    //public static final String SERVER_NAME = "http://10.24.49.198:3000/rectangle_POST";

    private EditText edWidth;
    private EditText edLength;
    private Button btnSend,btnBack;
    private TextView tvResult;

    String strWidth,strLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai2);
        edWidth = (EditText) findViewById(R.id.ed_width);
        edLength = (EditText) findViewById(R.id.ed_length);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnBack = (Button) findViewById(R.id.btn_back);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnSend.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                strWidth = edWidth.getText().toString();
                strLength = edLength.getText().toString();
                BackgroundTask_POST backgroundTask = new BackgroundTask_POST(tvResult,strWidth,strLength,this);
                backgroundTask.execute();
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }
}