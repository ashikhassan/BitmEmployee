package com.emythmakers.ashik.bitmemployee.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.emythmakers.ashik.bitmemployee.R;
import com.emythmakers.ashik.bitmemployee.database.ContactModel;

import java.util.ArrayList;
import java.util.Locale;


public class ContactAdapter extends BaseAdapter  {

    Activity mContext = null;
    ContactModel contactModel = null;
    ArrayList<ContactModel> mDisplayedValues = null;
    ArrayList<ContactModel> mOriginalValues = null;

    public ContactAdapter(Activity context, ArrayList<ContactModel> objects) {
        //super(context, R.layout.adapter_doctor, objects);
        this.mContext = context;
        this.mDisplayedValues = objects;
        this.mOriginalValues=new ArrayList<ContactModel>(); //if implements then this
        this.mOriginalValues.addAll(mDisplayedValues); // two lines not needed

    }




    // holder Class to contain inflated xml file elements
    static class ViewHolder {

        public TextView name;
        //public TextView phone;

    }

    @Override
    public int getCount() {
        return mDisplayedValues.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Create ListView row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get Model object from Array list
        contactModel = mDisplayedValues.get(position);
        ViewHolder mVHolder = null;

        View rowView = convertView;
        if (convertView == null) {

            // Layout inflater to call external xml layout ()
            LayoutInflater inflater = mContext.getLayoutInflater();

            rowView = inflater.inflate(R.layout.layout_adapter, parent, false);
            mVHolder = new ViewHolder();
            mVHolder.name = (TextView) rowView.findViewById(R.id.showName);
            //mVHolder.phone = (TextView) rowView.findViewById(R.id.showPhone);


            rowView.setTag(mVHolder);

        } else
            mVHolder = (ViewHolder) rowView.getTag();

        mVHolder.name.setText(contactModel.getName().toString());
        //mVHolder.phone.setText(contact.getmPhone().toString());


        return rowView;
    }


}
