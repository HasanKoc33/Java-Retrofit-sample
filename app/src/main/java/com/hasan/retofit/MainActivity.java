package com.hasan.retofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private RecyclerView eczaeneList;
    private EczaneAdaptor arapter;
    private  String baseUrl ="https://api.collectapi.com/";
    private EczaneApi eczaneApi;
    private Call<Post> postCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eczaeneList = findViewById(R.id.eczaneList);
        eczaeneList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        eczaeneList.setLayoutManager(llm);
        getData();
    }


    private void getData(){
       OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("authorization", "apikey 6E2kWZ6z6XUxywsRlhEo6Y:7k7p2oTGYEQORnmZT09H6T")
                        .addHeader("content-type","application/json").build();
                return chain.proceed(request);
            }
        });
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        eczaneApi = retrofit.create(EczaneApi.class);

        postCall = eczaneApi.getData();
        postCall.enqueue(new Callback<Post>(){

            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Post post = response.body();
                    if(post != null) {
                        Log.d("hasan", String.valueOf(post.getSuccess()));
                        arapter = new EczaneAdaptor(getApplicationContext(), post.getResult(), MainActivity.this);
                        eczaeneList.setAdapter(arapter);
                    }else {
                        Log.d("hasan", "Boşşşşşş");
                    }
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }
}