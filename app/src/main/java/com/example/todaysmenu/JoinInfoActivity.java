package com.example.todaysmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class JoinInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_info);
    }

    public void sellerCheck(View view) {
        CheckBox sellerCheck = (CheckBox)findViewById(R.id.sellerCheck);
        EditText sellerNum = (EditText)findViewById(R.id.businessNumInput);

        if(sellerCheck.isChecked()) {
            sellerNum.setEnabled(true);
        }
        else {
            sellerNum.setEnabled(false);
        }
    }

    public void join(View view) {
        EditText idInput = (EditText)findViewById(R.id.idInput);
        EditText pwInput = (EditText)findViewById(R.id.pwInput);
        EditText pwCheckDup = (EditText)findViewById(R.id.pwCheckDup);
        EditText nameInput = (EditText)findViewById(R.id.nameInput);
        EditText telNumInput = (EditText)findViewById(R.id.telNumInput);
        CheckBox sellerCheck = (CheckBox)findViewById(R.id.sellerCheck);
        EditText sellerNum = (EditText)findViewById(R.id.businessNumInput);

        if(!pwCheckDup.getText().toString().equals(pwInput.getText().toString())) {
            Toast.makeText(this, "비밀번호를 확인하시기 바랍니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
