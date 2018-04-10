package com.example.kosuda.akira.neverforget;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class MysizeFragment extends Fragment {

    public static Fragment newInstance(Context context){
        MysizeFragment f = new MysizeFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (RecyclerView.ViewHolder)inflater.inflate(R.layout.fragment_mysize,null);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("mysize",Context.MODE_PRIVATE);
        int neck = prefs.getInt("neck",0);
        int sleeve = prefs.getInt("sleeve",0);
        int waist = prefs.getInt("waist",0);
        int insideLeg = prefs.getInt("insideLeg",0);
        EditText edText1 = (EditText)getView().findViewById(R.id.editText1);
        if(neck!=0){edText1.setText(Integer.toString(neck));
        }

        EditText edText2 = (EditText)getView().findViewById(R.id.editText2);
        if(sleeve !=0){edText2.setText(Integer.toString(neck));
        }

        EditText edText3 = (EditText)getView().findViewById(R.id.editText3);
        if(waist !=0){edText3.setText(Integer.toString(neck));
        }
        EditText edText4 = (EditText)getView().findViewById(R.id.editText4);
        if(insideLeg !=0){edText4.setText(Integer.toString(neck));}

    }

    @Override
    public void onPause(){
        super.onPause();
        EditText edTText1 = (EditText)getView().findViewById(R.id.editText1);
        EditText edTText2 = (EditText)getView().findViewById(R.id.editText2);
        EditText edTText3 = (EditText)getView().findViewById(R.id.editText3);
        EditText edTText4 = (EditText)getView().findViewById(R.id.editText4);

        int neck;
        try{
            neck = Integer.parseInt(edTText1.getText().toString());
        }catch (NumberFormatException e){
            neck = 0;
        }


        int sleeve;
        try{
            sleeve = Integer.parseInt(edTText2.getText().toString());
        }catch (NumberFormatException e){
            sleeve = 0;
        }

        int waist;
        try{
            waist = Integer.parseInt(edTText3.getText().toString());
        }catch (NumberFormatException e){
            waist = 0;
        }

        int insideLeg;
        try{
            insideLeg = Integer.parseInt(edTText4.getText().toString());
        }catch (NumberFormatException e){
            insideLeg = 0;
        }

        SharedPreferences prefs = this.getActivity().getSharedPreferences("mysize",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("neck",neck);
        editor.putInt("sleeve",sleeve);
        editor.putInt("waist",waist);
        editor.putInt("insideLeg",insideLeg);

        editor.apply();
    }





}