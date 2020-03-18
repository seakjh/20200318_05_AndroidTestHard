package com.example.a20200318_05_androidtesthard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.a20200318_05_androidtesthard.databinding.ActivityUserInfoBinding;

public class UserInfoActivity extends AppCompatActivity {

    ActivityUserInfoBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info);

        String sendName = getIntent().getStringExtra("name");
        binding.nameTxt.setText(sendName);

        final String sendPhone = getIntent().getStringExtra("phonenum");
        binding.phoneNum.setText(sendPhone);

        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneUri = String.format("tel:%s", sendPhone);

                Uri uri = Uri.parse(phoneUri);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        binding.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, EditUserInfoActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            if (resultCode == RESULT_OK){
//                확인버튼을 눌러서 finish가 되었다!

//                첨부된 데이터가 있나 확인. => Intent data 변수에 들어있다.

                String name = data.getStringExtra("inputName");
                binding.nameTxt.setText(name);

                String phone = data.getStringExtra("inputPhoneNum");
                binding.phoneNum.setText(phone);

            }

    }
}
