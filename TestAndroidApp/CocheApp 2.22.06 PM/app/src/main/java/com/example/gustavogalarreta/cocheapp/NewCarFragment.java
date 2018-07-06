package com.example.gustavogalarreta.cocheapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gustavogalarreta.cocheapp.data.Car;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class NewCarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText etName, etBrand, etDoors, etWheels;
    private Button btSaveCar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NewCarFragment() {
        // Required empty public constructor
    }


    public static NewCarFragment newInstance(String param1, String param2) {
        NewCarFragment fragment = new NewCarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_car, container, false);

        etName = view.findViewById(R.id.name);
        etBrand = view.findViewById(R.id.brand);
        etDoors = view.findViewById(R.id.doors);
        etWheels = view.findViewById(R.id.wheels);
        btSaveCar = view.findViewById(R.id.saveCar);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference carReference = database.getReference("appCars");

        btSaveCar.setOnClickListener( (View v) -> {
            String name = etName.getText().toString();
            String brand = etBrand.getText().toString();
            int doors = Integer.parseInt(etDoors.getText().toString());
            int wheels = Integer.parseInt(etWheels.getText().toString());

            Car car = new Car(name, brand, doors, wheels);
            carReference.child("car").push().setValue(car);
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
