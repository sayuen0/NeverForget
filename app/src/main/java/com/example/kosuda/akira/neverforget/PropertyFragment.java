package com.example.kosuda.akira.neverforget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class PropertyFragment extends Fragment {

    public static Fragment newInstance(Context context){
        PropertyFragment f2 = new PropertyFragment();
        return f2;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_property, null);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property",Context.MODE_PRIVATE);
        int carNumber = prefs.getInt("car_number",0);
        int phoneNumber = prefs.getInt("phone_number",0);
        EditText edText1 = (EditText)getView().findViewById(R.id.editText1);
        if(carNumber!=0){edText1.setText(Integer.toString(carNumber));
        }

        EditText edText2 = (EditText)getView().findViewById(R.id.editText2);
        if(phoneNumber !=0){edText2.setText(Integer.toString(phoneNumber));
        }

    }

    @Override
    public void onPause(){
        super.onPause();
        EditText edTText1 = (EditText)getView().findViewById(R.id.editText1);
        EditText edTText2 = (EditText)getView().findViewById(R.id.editText2);

        int carNumber;
        try{
            carNumber = Integer.parseInt(edTText1.getText().toString());
        }catch (NumberFormatException e){
            carNumber = 0;
        }


        int phoneNumber;
        try{
            phoneNumber = Integer.parseInt(edTText2.getText().toString());
        }catch (NumberFormatException e){
            phoneNumber = 0;
        }


        SharedPreferences prefs = this.getActivity().getSharedPreferences("property",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("car_number",carNumber);
        editor.putInt("phone_number",phoneNumber);
        editor.apply();
    }




}
