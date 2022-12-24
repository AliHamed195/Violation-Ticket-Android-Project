package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {

    EditText emailLoginFragment, passwordLoginFragment;
    Button loginBtnLoginFragment;
    TextView forgetPasswordLoginFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        //Get the inputs and buttons from the view
        emailLoginFragment = root.findViewById(R.id.email);
        passwordLoginFragment = root.findViewById(R.id.password);
        loginBtnLoginFragment = root.findViewById(R.id.loginBtn);
        forgetPasswordLoginFragment = root.findViewById(R.id.forgetPassword);

        //Set action to login button
        loginBtnLoginFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailLoginFragment.getText().toString().isEmpty()){
                    emailLoginFragment.setError("Requierd filed.");
                    return;
                }
                if(passwordLoginFragment.getText().toString().isEmpty()){
                    passwordLoginFragment.setError("Requierd filed.");
                    return;
                }
                startActivity(new Intent(root.getContext(),Dashboard.class));
                getActivity().finish();
            }
        });

        return root;
    }
}
