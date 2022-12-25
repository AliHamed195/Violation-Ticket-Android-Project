package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {

    EditText emailLoginFragment, passwordLoginFragment;
    Button loginBtnLoginFragment;
    TextView forgetPasswordLoginFragment;
    AlertDialog.Builder reset_alert;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        //Get the inputs and buttons from the view
        emailLoginFragment = root.findViewById(R.id.email);
        passwordLoginFragment = root.findViewById(R.id.password);
        loginBtnLoginFragment = root.findViewById(R.id.loginBtn);
        forgetPasswordLoginFragment = root.findViewById(R.id.forgetPassword);

        //initialize the AlertDialog
        reset_alert = new AlertDialog.Builder(root.getContext());

        forgetPasswordLoginFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //geting the view to save it with the dialog
                View for_reset_password = inflater.inflate(R.layout.reset_pop_up_forget_password,null);

                //start the alert dialog
                reset_alert.setTitle("Reset Forget Password ?")
                        .setMessage("Enter Your email to get password reset link.")
                        .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //validate the email address
                                EditText email = for_reset_password.findViewById(R.id.resetEmailPopUpForgetPassword);
                                if(email.getText().toString().isEmpty()){
                                    email.setError("Requierd filed.");
                                    Toast.makeText(root.getContext(), "No Email Entered!!!!",Toast.LENGTH_LONG).show();
                                    return;
                                }
                                // send the link
                                Toast.makeText(root.getContext(), "Reset link sent.",Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("Cansel",null)
                        .setView(for_reset_password)
                        .create().show();
            }
        });

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
