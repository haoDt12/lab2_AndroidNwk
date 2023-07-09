package haodtph27524.fpoly.lab2.bai2;

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

import haodtph27524.fpoly.lab2.bai1.MainBai1;

public class BackgroundTask_POST extends AsyncTask<Void, Void, Void> {
    String duongdan = MainBai2.SERVER_NAME;
    TextView tvResult;
    String strWidth, strLength;
    String str;
    ProgressDialog progressDialog;
    Context context;

    public BackgroundTask_POST(TextView tvResult, String strWidth, String strLength, Context context) {
        this.tvResult = tvResult;
        this.strWidth = strWidth;
        this.strLength = strLength;
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
    protected Void doInBackground(Void... voids) {
        duongdan += "?chieurong=" + this.strWidth + "&chieudai=" + this.strLength;
        try {
            URL url = new URL(duongdan);
            String param = "chieurong=" + URLEncoder.encode(strWidth, "utf-8") + "&chieudai="
                    + URLEncoder.encode(strLength , "utf-8");
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
