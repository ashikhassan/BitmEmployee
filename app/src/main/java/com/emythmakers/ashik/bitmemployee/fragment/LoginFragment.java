package com.emythmakers.ashik.bitmemployee.fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.emythmakers.ashik.bitmemployee.R;
import com.emythmakers.ashik.bitmemployee.sharepreference.Preference;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    EditText userName;
    EditText password;
    Button btnLogin;
    Preference preference;
    Fragment fragment;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        userName=(EditText)view.findViewById(R.id.sUserName);
        password=(EditText)view.findViewById(R.id.sPassword);
        btnLogin=(Button)view.findViewById(R.id.btnLogin);

        preference=new Preference(getActivity());
        preference.Save("admin", "1234");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String pass = password.getText().toString();
                Boolean result=preference.Check(name, pass);
                if(result){
                    FragmentManager fragmentManager=getFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragment=new InsertFragment();
                    fragmentTransaction.replace(R.id.loginFragment, fragment);
                    fragmentTransaction.commit();
                    Toast.makeText(getActivity(),"Successfully Saved",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(),"Un Successfully",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
