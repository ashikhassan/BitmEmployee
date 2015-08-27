package com.emythmakers.ashik.bitmemployee.fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.emythmakers.ashik.bitmemployee.R;
import com.emythmakers.ashik.bitmemployee.adapter.ContactAdapter;
import com.emythmakers.ashik.bitmemployee.database.ContactModel;
import com.emythmakers.ashik.bitmemployee.database.DataSource;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    ListView listView;
    ContactAdapter contactAdapter;
    DataSource dataSource;
    ArrayList<ContactModel> employeeNameList;
    Fragment fragment;
    ContactModel contactModel;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        listView=(ListView)view.findViewById(R.id.employeeList);
        dataSource=new DataSource(getActivity());
        employeeNameList= new ArrayList<ContactModel>();
        employeeNameList=dataSource.getAllContact();
        contactAdapter= new ContactAdapter(getActivity(),employeeNameList);
        listView.setAdapter(contactAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {

                contactModel=employeeNameList.get(position);
                String positionID=contactModel.getId();
                ContactModel.setPositionID(positionID);
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragment=new ShowFragment();
                fragmentTransaction.replace(R.id.loginFragment, fragment);
                fragmentTransaction.commit();
                Toast.makeText(getActivity(), "Details for "+positionID, Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}
