package com.example.todaysmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); /*Start DB Helper*/

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "logint.db", null, 1);  // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 보냄
        dbHelper.insert("test", "test1");   //로그인 테스트용 data 임시 생성 (삭제될 예정)

        final EditText idEdit = (EditText)findViewById(R.id.id);            //xml에 정의한 android:id="@+id/id" 를 가지고 인스턴스 생성, 나중에 idEdit.getText().toString() 를 사용해서 데이터를 읽어온다.
        final EditText pwEdit = (EditText)findViewById(R.id.password);      //xml에 정의한 android:id="@+id/password" 를 가지고 인스턴스 생성, 나중에 pwEdit.getText().toString() 를 사용해서 데이터를 읽어온다.

        pwEdit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);    //비밀번호 입력시 텍스트 동그라미 모양으로 바꿔줌
        PasswordTransformationMethod pwTrans = new PasswordTransformationMethod();
        pwEdit.setTransformationMethod(pwTrans);

        /* start: DB에 있는 데이터 조회 */
        Button select = (Button) findViewById(R.id.loginButton);    //xml에 정의한 android:id="@+id/loginButton"과 매핑 선언, 이후부턴 login 버튼 클릭시 아래의 listener가 실행된다.
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int confirm_login = dbHelper.Login(idEdit.getText().toString(),pwEdit.getText().toString());    // ID, PW확인 후 값이 존재한다면 confirm_login에 1이 set됨

                if(confirm_login == 1) {    //로그인 확인 결과 일치한다면
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("id", idEdit.getText().toString());
                    startActivity(intent);
                }else {                     //ID,PW가 일치하지 않는다면
                    Toast.makeText(LoginActivity.this, "아이디 혹은 비밀번호를 확인하시기 바랍니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        /* end: DB에 있는 데이터 조회 */
    }
}
