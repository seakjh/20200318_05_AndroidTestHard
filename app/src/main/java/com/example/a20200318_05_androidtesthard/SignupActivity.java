package com.example.a20200318_05_androidtesthard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a20200318_05_androidtesthard.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        binding.signUpOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameTxt = binding.inputName.getText().toString();
                String phoneNum = binding.inputPhoneNum.getText().toString();

                Intent intent = new Intent(SignupActivity.this, UserInfoActivity.class);
                intent.putExtra("name", nameTxt);
                intent.putExtra("phonenum", phoneNum);

                startActivity(intent);
            }
        });

    }
}
