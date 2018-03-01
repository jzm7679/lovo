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
public class HomeFragment extends Fragment{
    /**
     *   可以把Fragment理解成Activity中的模块，这个模块有自己的布局，有自己的生命周期，单独处理自己的输入，
     *   在Activity运行的时候可以加载或者移除Fragment模块。还可以覆盖前面的一个页面，加载想要的模块
     * */

    public static HomeFragment newInstance(String param){
        HomeFragment fragment = new HomeFragment();
        // Bundle主要用于传递数据；它保存的数据，是以key-value(键值对)的形式存在的。
        Bundle bundle = new Bundle();
        bundle.putString("param", param);
        fragment.setArguments(bundle);
        return fragment;
    }

    public HomeFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("param");
        TextView tv = (TextView)view.findViewById(R.id.container);
        tv.setText(agrs1);
        return view;
    }

}
