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

import com.emythmakers.ashik.bitmemployee.database.ContactModel;
import com.emythmakers.ashik.bitmemployee.database.DataSource;
import com.emythmakers.ashik.bitmemployee.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertFragment extends Fragment {
    EditText sName;
    EditText sPhone;
    EditText sDesignation;
    Button btnSave;
    ContactModel contactModel;
    DataSource dataSource;
    Fragment fragment;



    public InsertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_insert, container, false);
        sName=(EditText)view.findViewById(R.id.sName);
        sPhone=(EditText)view.findViewById(R.id.sPhone);
        sDesignation=(EditText)view.findViewById(R.id.sDesignation);
        btnSave=(Button)view.findViewById(R.id.btnSubmite);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=sName.getText().toString();
                String phone=sPhone.getText().toString();
                String designation=sDesignation.getText().toString();
                contactModel=new ContactModel(name, phone, designation);
                dataSource=new DataSource(getActivity());
                long result=dataSource.insertData(contactModel);
                if(result>0){
                    FragmentManager fragmentManager=getFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragment=new ListFragment();
                    fragmentTransaction.replace(R.id.loginFragment, fragment);
                    fragmentTransaction.commit();
                    Toast.makeText(getActivity(),"Successfully Saved",Toast.LENGTH_SHORT).show();
                }

            }
        });


        return view;
    }


}
