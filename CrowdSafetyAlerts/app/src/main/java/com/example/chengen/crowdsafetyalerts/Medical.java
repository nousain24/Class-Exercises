package com.example.chengen.crowdsafetyalerts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class Medical extends AppCompatActivity {
    Button MedCall;
    Button MedMap;
    String target;
    EditText MedCondition;
    CheckBox my,an;
    ImageView medImage;
    String message;
    int sec,min,hour;
    private final static  String SERVER_ADDRESS ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        MedCall = (Button) findViewById(R.id.btnMed);
        MedCondition = (EditText) findViewById(R.id.etMedDes);
        my = (CheckBox)findViewById(R.id.cbMy);
        an = (CheckBox)findViewById(R.id.cbAnother);
        medImage = (ImageView)findViewById(R.id.ivMed);
        MedMap = (Button)findViewById(R.id.btnMedMap);
        MedCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(my.isSelected())
                    message =MedCondition.getText().toString();
                else
                    message = MedCondition.getText().toString();
                Calendar time = Calendar.getInstance();
                sec = time.getTime().getSeconds();
                min = time.getTime().getMinutes();
                hour = time.getTime().getHours();
                target = MapsActivity.getTarget();
                send();
                Bitmap image = ((BitmapDrawable) medImage.getDrawable()).getBitmap();
                new UploadImage(image, message);
            }
        });
        medImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 1);
            }
        });
        MedMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });
    }
    public void send(){
        Socket clientSocket=null;
        String time = hour+":"+min+":"+sec;
        try{
            clientSocket = new Socket("168.192.1.10",7000);
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeUTF("Medical:  "+time+"  "+target+"  "+message);
            outputStream.flush();
            outputStream.close();
            Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();
        }
        catch(IOException e)
        {
            Toast.makeText(getApplication(),"fail to send",Toast.LENGTH_SHORT).show();
        }
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
            Toast.makeText(getApplicationContext(),"Image Uploaded",Toast.LENGTH_SHORT).show();
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK&&data!=null){
            Uri selectedImage = data.getData();
            medImage.setImageURI(selectedImage);
        }
    }
    private HttpParams getHttpRequestParams(){
        HttpParams httpRequestParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpRequestParams, 1000 * 30);
        HttpConnectionParams.setSoTimeout(httpRequestParams,1000*30);
        return httpRequestParams;
    }
}

