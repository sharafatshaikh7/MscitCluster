package mscitcluster.com.mscitcluster;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import mscitcluster.com.mscitcluster.MainActivity;

/**
 * Created by yasmeenshaikh on 4/14/2016.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information...");
    }

    @Override
    protected String doInBackground(String... params) {
        ContentValues contentValues;
        //String reg_url="http://192.168.0.101/web_app/student_data.php";//10.0.3.2 when u using from genimotion
        String reg_url="http://mscit_cluster.net16.net/data_insert.php";
        //server uploded file adddress//http://mscit_cluster.net16.net/data_insert.php
        String login="http://mscit_cluster.net16.net/login.php";
        String method=params[0];
        if(method.equals("register"))
        {
            String name=params[1];
            String mob_number=params[2];
            String email_id=params[3];
            String pass=params[4];
            String confirm_pass=params[5];
            String college=params[6];
            String part=params[7];
            String image=params[8];
            try
            {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(String.valueOf(name),"UTF-8")+"&"+
                        URLEncoder.encode("mob_number","UTF-8")+"="+URLEncoder.encode(String.valueOf(mob_number),"UTF-8")+"&"+
                        URLEncoder.encode("email_id","UTF-8")+"="+URLEncoder.encode(String.valueOf(email_id),"UTF-8")+"&"+
                        URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(String.valueOf(pass),"UTF-8")+"&"+
                        URLEncoder.encode("confirm_pass","UTF-8")+"="+URLEncoder.encode(String.valueOf(confirm_pass),"UTF-8")+"&"+
                        URLEncoder.encode("college","UTF-8")+"="+URLEncoder.encode(String.valueOf(college),"UTF-8")+"&"+
                        URLEncoder.encode("part","UTF-8")+"="+URLEncoder.encode(String.valueOf(part),"UTF-8")+"&"+
                        URLEncoder.encode("image","UTF-8")+"="+URLEncoder.encode(String.valueOf(image),"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();
                InputStream is=httpURLConnection.getInputStream();
                is.close();
                return "Registration Success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login")){
            String username=params[1];
            String password=params[2];

            try {
                URL url=new URL(login);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                 BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                 String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                         URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                String responce="";
                String line="";
                while ((line =bufferedReader.readLine())!=null)
                {
                    responce+=line;
                }
                bufferedReader.close();
                is.close();
                httpURLConnection.disconnect();
                return responce;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {

        if(result.equals("Registration Success..."))
        {
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }else
        {
            alertDialog.setMessage(result);
            alertDialog.show();
        }

    }
}
