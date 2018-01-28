package com.demo.abdulrahmanrudwan.demotest.DemoSpinner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.demo.abdulrahmanrudwan.demotest.R;

import java.util.List;

/**
 * Created by Abdulrahman Rudwan on 14/12/2017.
 */


public class CarSpinnerAdapter extends ArrayAdapter<CarsModel> {
    List<CarsModel> models;
    Context context;
    TextView car_name;
    public CarSpinnerAdapter(@NonNull Context context, int resource, @NonNull List<CarsModel> objects) {
        super(context, resource, objects);
        models = objects;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position,convertView,parent);
    }



    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.custom_spinner_item,parent,false);
        car_name = convertView.findViewById(R.id.country_name);
        car_name.setText(models.get(position).getCarModel().getEnglishName());

        if(position==0){

            // Default selected Spinner item
            car_name.setText("Please select car");
            car_name.setText("");
        }
        else
        {
            // Set values for spinner each row
            car_name.setText(models.get(position).getCarModel().getEnglishName());


        }

        return convertView;
}


    @Override
    public int getCount() {
        return models.size();
    }

    @Nullable
    @Override
    public CarsModel getItem(int position) {
        return super.getItem(position);

    }

    @Override
    public int getPosition(@Nullable CarsModel item) {
        return super.getPosition(item);
    }

}
