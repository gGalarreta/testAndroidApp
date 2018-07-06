package com.example.gustavogalarreta.cocheapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gustavogalarreta.cocheapp.data.Car;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {

    ArrayList<Car> carList;

    public AdapterList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_list, null, false);
        return new ViewHolder(view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.assingData(carList.get(position));
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView car_name;
        TextView car_brand;
        TextView car_doors;
        TextView car_wheels;

        public ViewHolder(View itemView) {
            super(itemView);
            car_name = itemView.findViewById(R.id.carListName);
            car_brand = itemView.findViewById(R.id.carListBrand);
            car_doors = itemView.findViewById(R.id.carListDoors);
            car_wheels = itemView.findViewById(R.id.carListWheels);

        }

        public void assingData(Car car) {

            car_name.setText(car.getName());
            car_brand.setText(car.getBrand());
            car_wheels.setText(String.valueOf(car.getWheels()));
            car_doors.setText(String.valueOf(car.getDoors()));
        }
    }
}
