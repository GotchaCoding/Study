package org.techtown.androidwithjava.ch10_server.http.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

public class SampleMovieActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    static RequestQueue requestQueue;

    RecyclerView recyclerView;
    MovieAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_movie);

        editText = findViewById(R.id.editText_sampleMovie);
//        textView = findViewById(R.id.textView_adapter_movie);

        Button button = findViewById(R.id.btn_sampleMovie);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
            }
        });

        if (requestQueue == null) {    // 리퀘스트 객체가 널값이면  객체를 만듬.
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        recyclerView = findViewById(R.id.recyclerview_layout_movie);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MovieAdapter2();
        recyclerView.setAdapter(adapter);

    }


    public void makeRequest() {
        String url = editText.getText().toString();    //에딧텍스트에 적힌값 스트링 변수에 저장

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답 -> " + response);

                        processResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러 -> " + error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();

                return params;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
        println("요청 보냄.");
    }

    public void println(String data) {
        Log.d("MainActivity", data);
    }

    public void processResponse(String response) {
        Gson gson = new Gson();  //JSON 문자열을 자바 객체로 봐꾸어줌    volley는 웹으로 요청하고 응답받음.
        MovieList2 movieList = gson.fromJson(response, MovieList2.class);

        println("영화정보의 수 : " + movieList.boxOfficeResult.dailyBoxOfficeList.size());

        for (int i = 0; i < movieList.boxOfficeResult.dailyBoxOfficeList.size(); i++) {
            Movie2 movie = movieList.boxOfficeResult.dailyBoxOfficeList.get(i);  // Movie2 겍체만들고 거기에 MovieList2 객체의 Movie2와 연결된 어레이 리스트를 대입.


            adapter.addItem(movie);   //어레이리스트에 데이터 추가.
        }

        adapter.notifyDataSetChanged();
    }

}
