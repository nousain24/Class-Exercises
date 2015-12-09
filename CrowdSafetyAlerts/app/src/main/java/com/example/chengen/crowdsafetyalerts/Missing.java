package com.example.chengen.crowdsafetyalerts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.ImageButton;
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

public class Missing extends AppCompatActivity implements View.OnClickListener{
    EditText description,name,gender;
    Button send,MissMap;
    ImageView upload;
    ImageButton del;
    CheckBox find,lost;
    String target;
    int sec,min,hour;
    private static final String SERVER_ADDRESS = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing);
        description = (EditText) findViewById(R.id.etMiss);
        del = (ImageButton) findViewById(R.id.iBDel);
        send = (Button) findViewById(R.id.btnMiss);
        upload = (ImageView) findViewById(R.id.ivMiss);
        name = (EditText)findViewById(R.id.etName);
        gender = (EditText)findViewById(R.id.etGender);
        find = (CheckBox)findViewById(R.id.cbFind);
        lost = (CheckBox)findViewById(R.id.cblose);
        MissMap = (Button)findViewById(R.id.btnMissMap);
        target = MapsActivity.getTarget();
        send.setOnClickListener(this);
        del.setOnClickListener(this);
        upload.setOnClickListener(this);
        MissMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iBDel:
                upload.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.cap));
                break;
            case R.id.btnMiss:
                Bitmap image = ((BitmapDrawable) upload.getDrawable()).getBitmap();
                new UploadImage(image, description.getText().toString());
                Calendar time = Calendar.getInstance();
                sec = time.getTime().getSeconds();
                min = time.getTime().getMinutes();
                hour = time.getTime().getHours();
                send();
                break;
            case R.id.ivMiss:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 1);
                break;
            case R.id.btnMissMap:
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK&&data!=null){
            Uri selectedImage = data.getData();
            upload.setImageURI(selectedImage);
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
            Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT).show();
        }
    }
    public void send(){
        Socket clientSocket=null;
        String time = hour+":"+min+":"+sec;
        String des = "Name:"+name+" Gender:"+gender+" Description:"+description;
        try{
            clientSocket = new Socket("168.192.1.10",7000);
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            if(find.isSelected()&&lost.isSelected()!=true)
                outputStream.writeUTF("Found: "+time+"  "+target+"  "+des);
            else if(lost.isSelected()&&find.isSelected()!=true)
                outputStream.writeUTF("Lost: "+time+"  "+target+"  "+des);
            else
                Toast.makeText(getApplicationContext(),"You can only choose one",Toast.LENGTH_SHORT).show();
            outputStream.flush();
            outputStream.close();
            Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_SHORT).show();
        }
        catch(IOException e)
        {
            Toast.makeText(getApplicationContext(),"Fail to send",Toast.LENGTH_SHORT).show();
        }
    }
    private HttpParams getHttpRequestParams(){
        HttpParams httpRequestParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpRequestParams, 1000 * 30);
        HttpConnectionParams.setSoTimeout(httpRequestParams,1000*30);
        return httpRequestParams;
    }
}

