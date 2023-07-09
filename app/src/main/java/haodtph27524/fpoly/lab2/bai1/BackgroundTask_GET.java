package haodtph27524.fpoly.lab2.bai1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class BackgroundTask_GET extends AsyncTask<Void, Void , Void> {
    String duongdan = MainBai1.SERVER_NAME;
    TextView tvResult;
    String strName, strScore;
    String str;
    ProgressDialog progressDialog;
    Context context;

    public BackgroundTask_GET(TextView tvResult, String strName, String strScore, Context context) {
        this.tvResult = tvResult;
        this.strName = strName;
        this.strScore = strScore;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Sending...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        duongdan += "?name=" + this.strName + "&score=" + this.strScore;
        try {
            URL url = new URL(duongdan);
            //HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = bfr.readLine()) != null){
                sb.append(line);
            }
            str = sb.toString();
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(str);
    }
}
