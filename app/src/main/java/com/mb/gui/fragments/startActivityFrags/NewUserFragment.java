package com.mb.gui.fragments.startActivityFrags;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewUserFragment extends Fragment {


    public NewUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        log("New user fragment onCreateView methode.");
        return inflater.inflate(R.layout.fragment_new_user, container, false);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("New user fragment OnCreate methode.");
    }

    @Override
    public void onStop() {
        super.onStop();
        log("New user fragment onStop methode.");
    }

    @Override
    public void onResume() {
        super.onResume();
        log("New user fragment onResume methode.");
    }

    @Override
    public void onStart() {
        super.onStart();
        log("New user fragment onStart methode.");
    }



    private void log(String msg){
        Log.i("msg",msg);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        log("New user fragment onAttach methode. The context: "+context.getPackageCodePath());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        log("New user fragment onDetach methode. The context: ");
    }



}
