package com.example.todaysmenu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        /* 이름은 LOGINT이고, 자동으로 값이 증가하는 _id 정수형 기본키 컬럼과
        item 문자열 컬럼, price 정수형 컬럼, create_at 문자열 컬럼으로 구성된 테이블을 생성. */
        db.execSQL("CREATE TABLE LOGINT (_id INTEGER PRIMARY KEY AUTOINCREMENT, ID TEXT, PW TEXT);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String ID_m, String PW_m) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO LOGINT VALUES(null,'" + ID_m + "', '" + PW_m + "');");
        db.close();
    }

    /*Login*/
    public int Login(String ID_m, String PW_m) {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        int result = 0;

        // DB에 있는 데이터 조회
        Cursor cursor = db.rawQuery("SELECT * FROM LOGINT WHERE ID='" + ID_m + "' AND PW='" + PW_m + "'  ", null);
        while (cursor.moveToNext()) {
            result = 1;
        }

        return result;
    }
}