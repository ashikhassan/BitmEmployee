package com.emythmakers.ashik.bitmemployee.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.emythmakers.ashik.bitmemployee.R;
import com.emythmakers.ashik.bitmemployee.database.DataSource;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    DataSource dataSource;
    ArrayList<String> employeeNameList;
    Fragment fragment;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        listView=(ListView)view.findViewById(R.id.employeeList);
        dataSource=new DataSource(getActivity());
        employeeNameList= new ArrayList<>();
        employeeNameList=dataSource.GetAllEmployeeName();
        arrayAdapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, employeeNameList);
        listView.setAdapter(arrayAdapter);
        return view;
    }
}
