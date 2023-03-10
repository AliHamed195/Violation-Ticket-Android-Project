package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
import com.example.myapplication.forApi.LoginRequest;
import com.example.myapplication.forApi.LoginService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class LoginTabFragment extends Fragment {


    String messageForEmailValidation, messageForPasswordValidation;
    EditText emailLoginFragment, passwordLoginFragment;
    Button loginBtnLoginFragment;
    TextView forgetPasswordLoginFragment, rigister;
    AlertDialog.Builder reset_alert;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        //Get the inputs and buttons from the view
        emailLoginFragment = root.findViewById(R.id.email);
        passwordLoginFragment = root.findViewById(R.id.password);
        loginBtnLoginFragment = root.findViewById(R.id.loginBtn);
        forgetPasswordLoginFragment = root.findViewById(R.id.forgetPassword);
        rigister = root.findViewById(R.id.rigisternow);

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

        rigister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),Rigister.class));
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


/*

                // to send the data using API
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://10.0.2.5:5000/")
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
                        //Toast.makeText(getContext(),t.toString(), Toast.LENGTH_LONG).show();
                    }
                });
*/

// Define the LoginRequest class


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost:8080/pro/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                // Create a request body object
                LoginRequest request = new LoginRequest(emailLoginFragment.getText().toString(), passwordLoginFragment.getText().toString());

                // Create the service and make the request
                LoginService service = retrofit.create(LoginService.class);
                Call<ResponseBody> call = service.login(request);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                String responseString = response.body().string();
                                if(responseString.equalsIgnoreCase("done")){
                                    // Login successful
                                    Toast.makeText(getContext(), responseString.toString(), Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(root.getContext(),Dashboard.class));
                                    getActivity().finish();
                                }else  {
                                    // Login failed
                                    Toast.makeText(getContext(), responseString.toString(), Toast.LENGTH_SHORT).show();

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getContext(), "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // Handle the failure here
                        Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



//                startActivity(new Intent(root.getContext(),Dashboard.class));
//                getActivity().finish();



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

    private class LoginTask extends AsyncTask<Void, Void, Integer> {
        @Override
        protected Integer doInBackground(Void... voids) {
            int statusCode = 0;
            try {
                URL url = new URL("http://localhost:5000/api/Auth/login");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("userName", emailLoginFragment.getText().toString());
                jsonParam.put("password", passwordLoginFragment.getText().toString());
                // get the status code
                statusCode = conn.getResponseCode();
                return statusCode;
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                return statusCode;
            }
        }

        @Override
        protected void onPostExecute(Integer statusCode) {
            if (statusCode == HttpURLConnection.HTTP_OK) {
                // The request was successful
            } else {
                // The request was not successful
            }
        }
    }


}
