package com.example.socialservice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomePage extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         View view = inflater.inflate(R.layout.activity_home_page, container, false);
         CardView cardView = view.findViewById(R.id.card1);
         cardView.setCardElevation(8.00f);
         return view;

    }
}
