package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import androidx.fragment.app.Fragment;

import com.example.myapplication.forApi.LoginClass;
import com.example.myapplication.forApi.LoginApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginTabFragment extends Fragment {

    String messageForEmailValidation, messageForPasswordValidation;
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
                                if(!validateEmailAddress(email)){
                                    email.setError(messageForEmailValidation);
                                    Toast.makeText(root.getContext(), "No Email Entered!!!!",Toast.LENGTH_LONG).show();
                                    return;
                                }else{
                                    email.setError(null);
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
                //Need to complete the validation
                if(!validateEmailAddress(emailLoginFragment)){
                    emailLoginFragment.setError(messageForEmailValidation);
                    return;
                }else{
                    emailLoginFragment.setError(null);
                }
                if(!validatePassword(passwordLoginFragment)){
                    passwordLoginFragment.setError(messageForPasswordValidation);
                    return;
                }else{
                    passwordLoginFragment.setError(null);
                }

                // to send the data using API
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("http://10.0.2.2:5000")
                        .build();
                LoginApi api = retrofit.create(LoginApi.class);
                LoginClass data = new LoginClass(emailLoginFragment.getText().toString(), passwordLoginFragment.getText().toString());
                Call<ResponseBody> call = api.saveData(data);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            // the intint should be here
                            Toast.makeText(getContext(),"done", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(root.getContext(),Dashboard.class));
                            getActivity().finish();
                        } else {
                            Toast.makeText(getContext(),response.toString(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getContext(),t.toString(), Toast.LENGTH_LONG).show();
                    }
                });

                startActivity(new Intent(root.getContext(),Dashboard.class));
                getActivity().finish();


            }
        });

        return root;
    }

    private boolean validateEmailAddress(EditText email){
        String emailInput = email.getText().toString();

        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            return true;
        }else if(emailInput.isEmpty()){
            messageForEmailValidation = "Email can not be empty !!!!";
            return false;
        }else{
            messageForEmailValidation = "Invalid Email !!!!";
            return false;
        }
    }

    private boolean validatePassword(EditText pass){
        String passwordInput = pass.getText().toString();
        String checkSpaces = "\\A\\w{1,40}\\z";

        if(!passwordInput.isEmpty() && passwordInput.matches(checkSpaces)){
            return true;
        }else if(passwordInput.isEmpty()){
            messageForPasswordValidation = "Password can not be empty !!!!";
            return false;
        }else{
            messageForPasswordValidation = "No white spaces are allowed !!!!";
            return false;
        }
    }

}
