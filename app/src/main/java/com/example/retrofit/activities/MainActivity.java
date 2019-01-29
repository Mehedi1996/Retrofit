package com.example.retrofit.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.R;
import com.example.retrofit.models.FlowerList;
import com.example.retrofit.models.FlowerResponse;
import com.example.retrofit.retrofits.ApiClient;
import com.example.retrofit.retrofits.FlowerServiceApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FlowerServiceApi flowerServiceApi;
    TextView TVname;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TVname = findViewById(R.id.name);

        flowerServiceApi = ApiClient.getRetrofitInstance().create(FlowerServiceApi.class);

        Call<FlowerResponse> responseCall = flowerServiceApi.getFlowerResponse();

        responseCall.enqueue(new Callback<FlowerResponse>() {
            @Override
            public void onResponse(Call<FlowerResponse> call, Response<FlowerResponse> response) { ///its not working becaue//check now okk
                if (response.isSuccessful()) {
                    FlowerResponse flowerResponse = response.body();

                    if (flowerResponse != null) {
                        List<FlowerList> flowerLists = flowerResponse.getFlowerlist();
                        Toast.makeText(MainActivity.this, "" + flowerLists.get(1).getName() + "\n" + flowerLists.get(1)
                                .getCategory() + "\n" + flowerLists.get(1).getProductId(), Toast.LENGTH_LONG).show();

                        String secondIndexName = flowerLists.get(2).getName()+"\n"+flowerLists.get(2).getCategory()+"\n"+flowerLists.get(2).getProductId();
                        TVname.setText(secondIndexName);

                    } else {
                        Toast.makeText(MainActivity.this, "" + new Exception(response.message()), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "" + new Exception(response.message()), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FlowerResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + new Exception(t.getMessage()), Toast.LENGTH_LONG).show();
            }
        });
    }
}
