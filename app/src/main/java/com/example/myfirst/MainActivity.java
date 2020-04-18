package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int GALLERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEntryButtonClick(View v) { setContentView(R.layout.my_profile); }

    public void onUploadPicButtonClick(View v) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        ImageView imageView = (ImageView) findViewById(R.id.avatar);
        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK) {
                    Uri selectedImageURI = imageReturnedIntent.getData();
                    imageView.setImageURI(selectedImageURI);
                }
            default:
        }
    }
}
