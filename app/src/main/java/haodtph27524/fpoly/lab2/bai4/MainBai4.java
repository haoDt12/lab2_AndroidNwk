package haodtph27524.fpoly.lab2.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import haodtph27524.fpoly.lab2.R;
import haodtph27524.fpoly.lab2.bai3.Bai3_POST;

public class MainBai4 extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.1.3:80/haodt_ph27524/giaiphuongtrinh_post.php";

    private EditText edA;
    private EditText edB;
    private EditText edC;
    private Button btnSend,btnBack;
    private TextView tvResult;
    String strA,strB,strC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai4);
        edA = (EditText) findViewById(R.id.ed_a);
        edB = (EditText) findViewById(R.id.ed_b);
        edC = (EditText) findViewById(R.id.ed_c);
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
                strA = edA.getText().toString();
                strB = edB.getText().toString();
                strC = edC.getText().toString();
                Bai4_POST bai4_post = new Bai4_POST(tvResult,this);
                bai4_post.execute(strA,strB,strC);
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }
}