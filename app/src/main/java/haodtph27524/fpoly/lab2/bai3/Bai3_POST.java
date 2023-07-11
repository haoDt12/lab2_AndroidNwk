package haodtph27524.fpoly.lab2.bai3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;



public class Bai3_POST extends AsyncTask<String, Void, Void> {
    String duongdan = MainBai3.SERVER_NAME;
    TextView tvResult;
    String strResult;
    ProgressDialog progressDialog;
    Context context;

    public Bai3_POST(TextView tvResult,Context context) {
        this.tvResult = tvResult;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Calculating...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(String... params) {
        try {
            URL url = new URL(duongdan);
            String param = "canh=" + URLEncoder.encode(params[0].toString(),"utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Context-Type","application/x-www-form-urlencoded");

            PrintWriter print = new PrintWriter(urlConnection.getOutputStream());
            print.print(param);
            print.close();


            String line = "";
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = bfr.readLine()) != null){
                sb.append(line);
            }
            strResult = sb.toString();
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
        tvResult.setText(strResult) ;
    }
}
