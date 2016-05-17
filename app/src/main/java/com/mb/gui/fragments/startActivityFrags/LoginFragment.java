package com.mb.gui.fragments.startActivityFrags;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.mb.R;
import com.mb.gui.activities.StartActivity;

public class LoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private TextView newaccount_TextView, forgotpassword_TextView;
    private CheckBox rememeber_CheckBox;
    private Button login_Button;
    private EditText username_EditText, password_EditText;

    private NewUserFragment newUserFragment;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean mParam3;
    private StartActivity rootActivity;
    private ProgressDialog progressDialog;

    public LoginFragment() {
    }

    /**
     * @param param1 Parameter 1. username
     * @param param2 Parameter 2. password
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2, boolean mParam3) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putBoolean(ARG_PARAM3,mParam3);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.newUserFragment = new NewUserFragment();
        log("Login fragment onCreate methode.");

    }

    private  ActionBar bar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        log("Login fragment onCreateView methode.");
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        TextView logo = (TextView)view.findViewById(R.id.textView_Logo);
        Animation animation = AnimationUtils.loadAnimation(view.getContext(),
                R.anim.fadin);
        logo.setAnimation(animation);

        this.forgotpassword_TextView = (TextView) view.findViewById(R.id.textView_forgotpassLoginFrag);
        this.rememeber_CheckBox = (CheckBox) view.findViewById(R.id.checkBox_remember);
        this.login_Button = (Button) view.findViewById(R.id.button_loginLoginFrag);
        this.login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHomeActivityOnClicked();
            }
        });
        this.username_EditText = (EditText) view.findViewById(R.id.editText_usernameLoginFrag);
        this.password_EditText = (EditText) view.findViewById(R.id.editText_passwordLoginFrag);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getBoolean(ARG_PARAM3);
            this.rememeber_CheckBox.setChecked(mParam3);
        }


        this.newaccount_TextView = (TextView) view.findViewById(R.id.textView_newaccountLoginFrag);
        if (bar!=null){
            bar.hide();
        }
        this.newaccount_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.setTitle("New user");
                bar.show();
                FragmentTransaction fragmentTransaction =  getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.layout_Startactivity_fragmentcontainer,newUserFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        return view;
    }

    private void startHomeActivityOnClicked() {

        AsyncTask<Void,Void,Void> homstartTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Intent intent = new Intent("com.mb.gui.activities.StartActivity");
                startActivity(intent);
                return null;
            }

            @Override
            protected void onPreExecute() {
                progressDialog = ProgressDialog.show(getView().getContext(),"Signing in.","Please waite...");
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                progressDialog.dismiss();
                super.onPostExecute(aVoid);
            }
        }.execute();



    }


    @Override
    public void onStop() {
        super.onStop();
        log("Login fragment onStop methode.");
    }

    @Override
    public void onResume() {
        super.onResume();
        log("Login fragment onResume methode.");
    }

    @Override
    public void onStart() {
        super.onStart();
        log("Login fragment onStart methode.");
    }



    private void log(String msg){
        Log.i("msg",msg);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        log("Login fragment onAttach methode. The context: "+context.getPackageCodePath());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        log("Login fragment onDetach methode. The context: ");
    }

    public void setRootActivity(StartActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public void setBar(ActionBar bar) {
        this.bar = bar;
    }


}
