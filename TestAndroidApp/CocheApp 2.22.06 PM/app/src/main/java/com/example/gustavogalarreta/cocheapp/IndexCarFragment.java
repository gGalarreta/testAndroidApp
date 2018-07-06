package com.example.gustavogalarreta.cocheapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gustavogalarreta.cocheapp.data.Car;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;


public class IndexCarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    ArrayList<Car> carList = new ArrayList<>();
    RecyclerView recycler;
    private FirebaseDatabase database;
    private DatabaseReference carReference;
    private RecyclerView.Adapter currentAdapter;
    private OnFragmentInteractionListener mListener;

    public IndexCarFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static IndexCarFragment newInstance(String param1, String param2) {
        IndexCarFragment fragment = new IndexCarFragment();
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


        database = FirebaseDatabase.getInstance();
        carReference = database.getReference().child("appCars").child("car");



        View view = inflater.inflate(R.layout.fragment_index_car, container, false);
        recycler =  view.findViewById(R.id.recyclerId);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(layoutManager);
        fillList();
        return view;
    }

    public void fillList() {
        carReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot childSnapshot : dataSnapshot.getChildren()){
                    try{
                        Car carItem = childSnapshot.getValue(Car.class);
                        carList.add(carItem);
                        currentAdapter = new AdapterList(carList);
                        recycler.setAdapter(currentAdapter);
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    //callback.onResponse(carList);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //callback.onError();
            }
        });
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
