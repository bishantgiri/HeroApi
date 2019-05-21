package com.example.heroapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.HeroesAdapter;
import heroesapi.HeroesAPI;
import model.Heroes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class ViewHeroes extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Heroes> heroesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_heroes);

        recyclerView=findViewById(R.id.recyclerView);
        //heroesList=new ArrayList<>();

        HeroesAPI heroesAPI= Url.getInstance().create(HeroesAPI.class);
        Call<List<Heroes>> call=heroesAPI.getAllHeroes();

        call.enqueue(new Callback<List<Heroes>>() {
            @Override
            public void onResponse(Call<List<Heroes>> call, Response<List<Heroes>> response) {
                heroesList=response.body();
                HeroesAdapter heroesAdapter=new HeroesAdapter(heroesList,ViewHeroes.this);
                recyclerView.setAdapter(heroesAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(ViewHeroes.this));
            }

            @Override
            public void onFailure(Call<List<Heroes>> call, Throwable t) {

            }
        });

    }
}
