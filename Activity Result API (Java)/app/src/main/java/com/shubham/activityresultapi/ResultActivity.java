package com.shubham.activityresultapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shubham.activityresultapi.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_result);
        binding = DataBindingUtil.setContentView(ResultActivity.this, R.layout.activity_result);


        binding.btnSendResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("result", binding.etMessage.getText().toString());
                setResult(78, intent);

//                finish();
                ResultActivity.super.onBackPressed();
            }
        });
    }



}