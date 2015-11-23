package com.example.chengen.crowdsafetyalerts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

public class Sanitary extends AppCompatActivity {
    private EditText txtLocation;
    private EditText txtTime;
    private Button SanMap,btnRequest;
    private ImageView imageView;
    private static String target;
    private String message;
    private final static String SERVER_ADDRESS="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanitary);
        txtLocation = (EditText)findViewById(R.id.etCleanLoc);
        txtTime = (EditText)findViewById(R.id.etCleanTIme);
        SanMap = (Button)findViewById(R.id.btnSanMap);
        btnRequest = (Button)findViewById(R.id.btnClean);
        imageView = (ImageView)findViewById(R.id.ivSan);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap image = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                new UploadImage(image, txtLocation.getText().toString());
                target = MapsActivity.getTarget();
                message = txtLocation.getText().toString()+" "+"Request time:"+txtTime.getText().toString();
                target = MapsActivity.getTarget();
                send();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 1);
            }
        });
        SanMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });
    }
    private class UploadImage extends AsyncTask<Void, Void, Void> {
        Bitmap image;
        String name;
        public UploadImage(Bitmap image,String name)
        {
            this.image=image;
            this.name = name;
        }
        @Override
        protected Void doInBackground(Void... params){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
            String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
            ArrayList<NameValuePair> dataToSend = new ArrayList<>();
            dataToSend.add(new BasicNameValuePair("image",encodedImage));
            dataToSend.add(new BasicNameValuePair("name",name));
            HttpParams httpParams = getHttpRequestParams();
            DefaultHttpClient client = new DefaultHttpClient(httpParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS+"SavePicture.php");
            try{
                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                client.execute(post);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT).show();
        }
    }
    private HttpParams getHttpRequestParams(){
        HttpParams httpRequestParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpRequestParams, 1000 * 30);
        HttpConnectionParams.setSoTimeout(httpRequestParams,1000*30);
        return httpRequestParams;
    }
    public void send()
    {
        Calendar now = Calendar.getInstance();
        int sec = now.getTime().getSeconds();
        int min = now.getTime().getMinutes();
        int hour = now.getTime().getHours();
        String moment = hour+":"+min+":"+sec;
        Socket clientSocket=null;
        try{
            clientSocket = new Socket("168.192.1.10",7000);
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeUTF("Sanitary:"+"  "+moment+"  "+target+"  "+message);
            outputStream.flush();
            outputStream.close();
            Toast.makeText(getApplication(), "sending Successful", Toast.LENGTH_SHORT).show();
        }
        catch(IOException e)
        {
            Toast.makeText(getApplicationContext(),"Fail to Send",Toast.LENGTH_SHORT).show();
        }
    }
}
