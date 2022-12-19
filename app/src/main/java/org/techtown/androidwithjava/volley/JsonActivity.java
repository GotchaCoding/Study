package org.techtown.androidwithjava.volley;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.techtown.androidwithjava.R;

import java.util.HashMap;
import java.util.Map;

public class JsonActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    static RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        editText = findViewById(R.id.editText_json);
        textView = findViewById(R.id.textView_json);

        Button button =findViewById(R.id.btn_json);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
            }
        });

        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());  //RequestQueue 객체 생성.
        }

    }

    public void makeRequest() {
        String url = editText.getText().toString();

        StringRequest request = new StringRequest(        //StringRequest 객체??  메서드??
                Request.Method.GET,url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답 -> " + response);   // 2 번째로 실행됨

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러 -> " + error.getMessage());   //java.lang.RuntimeException: Bad URL
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {  //Map은 인터페이스..  그리고 메서드자리인가?
                Map<String,String> params = new HashMap<String,String>();

                return params;
            }
        };

        request.setShouldCache(false);    //request 객체만든거 여기서 사용 .
        requestQueue.add(request);
        println("요청 보냄.");   //  1. 이게먼저 뜸
    }

    public void println(String data) {
        textView.append(data + "\n");
    }


    public void processResponse(String response){
        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(response, MovieList.class);
        println("영화 정보의 수 : " + movieList.boxOfficeResult.dailyBoxOfficeList.size());
    }
}


