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
import android.widget.TextView;
import android.widget.Toast;

import com.emythmakers.ashik.bitmemployee.R;
import com.emythmakers.ashik.bitmemployee.database.ContactModel;
import com.emythmakers.ashik.bitmemployee.database.DataSource;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {
    DataSource dataSource;
    EditText sName;
    EditText sPhone;
    EditText sDesignation;
    Button btnUpdate;
    ContactModel contactModel;
    Fragment fragment;



    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_edit, container, false);
        sName=(EditText)view.findViewById(R.id.sName);
        sPhone=(EditText)view.findViewById(R.id.sPhone);
        sDesignation=(EditText)view.findViewById(R.id.sDesignation);
        btnUpdate=(Button)view.findViewById(R.id.btnUpdate);

        final String positionID=ContactModel.getPositionID();
        dataSource=new DataSource(getActivity());

        contactModel=new ContactModel(positionID);
        contactModel=dataSource.singleContact(positionID);

        sName.setText(contactModel.getName());
        sPhone.setText(contactModel.getPhoneNo());
        sDesignation.setText(contactModel.getDesignation());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=sName.getText().toString();
                String phone=sPhone.getText().toString();
                String designation=sDesignation.getText().toString();
                contactModel=new ContactModel(name, phone, designation);
                dataSource=new DataSource(getActivity());
                boolean result=dataSource.updateData(positionID, contactModel);
                if(result){
                    FragmentManager fragmentManager=getFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragment=new ListFragment();
                    fragmentTransaction.replace(R.id.loginFragment, fragment);
                    fragmentTransaction.commit();
                    Toast.makeText(getActivity(), "Successfully Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


}
