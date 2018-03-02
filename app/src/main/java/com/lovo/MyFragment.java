package com.lovo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jzm76 on 2018/3/1.
 */

public class MyFragment extends Fragment{

    public static MyFragment newInstance(String param){
        MyFragment fragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param", param);
        fragment.setArguments(bundle);
        return fragment;
    }

    public MyFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
//        Bundle bundle = getArguments();
//        String param = bundle.getString("param");
//        TextView tv = (TextView)view.findViewById(R.id.mMy);
//        tv.setText(param);
        return view;
    }

}
