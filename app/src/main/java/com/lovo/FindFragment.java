package com.lovo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jzm76 on 2018/3/2.
 */
public class FindFragment extends Fragment {

    public static FindFragment newInstance(String param){
        FindFragment fragment = new FindFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param", param);
        fragment.setArguments(bundle);
        return fragment;
    }

    public FindFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment, container, false);
        Bundle bundle = getArguments();
        String param = bundle.getString("param");
        TextView textView = (TextView) view.findViewById(R.id.mFind);
        textView.setText(param);
        return textView;
    }
}
