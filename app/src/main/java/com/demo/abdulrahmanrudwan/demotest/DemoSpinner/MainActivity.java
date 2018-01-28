package com.demo.abdulrahmanrudwan.demotest.DemoSpinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.demo.abdulrahmanrudwan.demotest.R;
import com.demo.abdulrahmanrudwan.demotest.VolleySingleton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import gr.escsoft.michaelprimez.searchablespinner.SearchableSpinner;
import gr.escsoft.michaelprimez.searchablespinner.interfaces.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    SearchableSpinner myspinner;
    SearchableSpinner myspinner2;
    List<CarsModel> carsModelList;
    List<CountriesCitiesModel> countriesModelList;
    CarSpinnerAdapter adapter;
    CountrySpinnerAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myspinner = findViewById(R.id.myspinner);
        myspinner2 = findViewById(R.id.myspinner2);
        getCars();
        getcountries();
        myspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(View view, int position, long id) {
                String name = carsModelList.get(position).getCarModel().getEnglishName();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected() {

            }
        });

        myspinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(View view, int position, long id) {
                String name = countriesModelList.get(position).getCountry().getEnglishName();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected() {

            }
        });

    }

    void getCars() {
        StringRequest request = new StringRequest(Request.Method.GET, "http://service.sheelapp.com/api/drivers/getcar", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Type listType = new TypeToken<List<CarsModel>>() {
                }.getType();
                carsModelList = (List<CarsModel>) new Gson().fromJson(response, listType);

                adapter = new CarSpinnerAdapter(MainActivity.this, 0, carsModelList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                myspinner.setAdapter(adapter);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
    }

    void getcountries() {
        StringRequest request = new StringRequest(Request.Method.GET, "http://service.sheelapp.com/api/drivers/getcountrycity", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Type listType = new TypeToken<List<CountriesCitiesModel>>() {
                }.getType();
               countriesModelList = (List<CountriesCitiesModel>) new Gson().fromJson(response, listType);

                adapter2 = new CountrySpinnerAdapter(MainActivity.this, 0, countriesModelList);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                myspinner2.setAdapter(adapter2);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("er",error.getMessage().toString());
            }
        });
        VolleySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
    }
}
