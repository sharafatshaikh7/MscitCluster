package mscitcluster.com.mscitcluster;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by yasmeenshaikh on 4/14/2016.
 */
public class FeedBackDataEntry extends AsyncTask<String,Void,String> {
    Context ctx;
    public FeedBackDataEntry(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String reg_url="http://mscit_cluster.net16.net/feedback_insert.php";//10.0.3.2 when u using from genimotion
        String method=params[0];
        if(method.equals("register"))
        {
            String name=params[1];
            String email=params[2];
            String suggestion=params[3];
            String rating=params[4];
            try
            {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(String.valueOf(name),"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(String.valueOf(email),"UTF-8")+"&"+
                        URLEncoder.encode("suggestion","UTF-8")+"="+URLEncoder.encode(String.valueOf(suggestion),"UTF-8")+"&"+
                        URLEncoder.encode("rating","UTF-8")+"="+URLEncoder.encode(String.valueOf(rating),"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();
                InputStream is=httpURLConnection.getInputStream();
                is.close();
                return "Feedback/Suggestion Submited...";

            } catch (MalformedURLException e) {
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
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
