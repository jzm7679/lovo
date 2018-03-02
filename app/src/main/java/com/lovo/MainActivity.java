package com.lovo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{

    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    private String TAG = MainActivity.class.getSimpleName(); // MainActivity

    // Fragment
    private HomeFragment homeFragment;
    private MyFragment myFragment;
    private FindFragment findFragment;
    private ShopFragment shopFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bottomNavigationBar 设置
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        // 导航基础设计，包括 按钮选中效果、导航栏背景色
        bottomNavigationBar.setTabSelectedListener(this)
                /**
                 *  setMode() 内的参数有三种模式类型：
                 *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
                 *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
                 *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
                 */
                .setMode(BottomNavigationBar.MODE_FIXED)
                /**
                 *  setBackgroundStyle() 内的参数有三种样式
                 *  BACKGROUND_STYLE_DEFAULT: 默认样式 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC
                 *                                    如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
                 *  BACKGROUND_STYLE_STATIC: 静态样式 点击无波纹效果
                 *  BACKGROUND_STYLE_RIPPLE: 波纹样式 点击有波纹效果
                 */
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                // 选中颜色
                .setActiveColor("#ff0000")
                // 未选中颜色
                .setInActiveColor("#000000")

                // 导航栏背景色
                .setBarBackgroundColor("#ffffff");

        // 添加导航按钮
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.tabbar_home_normal_2, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.tabbar_find_normal_2, "发现"))
                .addItem(new BottomNavigationItem(R.mipmap.tabbar_shopping_normal_2, "逛一逛"))
                .addItem(new BottomNavigationItem(R.mipmap.tabbar_user_normal_2, "我的"))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();

        // 设置默认导航栏
        setDefaultFragment();
    }

    /**
     * 设置默认导航栏
     * */
    private void setDefaultFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        homeFragment = HomeFragment.newInstance("首页");
        transaction.replace(R.id.tb, homeFragment);
        transaction.commit();
    }

    /**
     * 设置导航选中的事件
     */
    @Override
    public void onTabSelected(int position) {
        FragmentManager fragmentManager = this.getFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (position){
            case 0:
                if(homeFragment == null){
                    homeFragment = HomeFragment.newInstance("首页");
                }
                transaction.replace(R.id.tb, homeFragment);
                break;
            case 1:
                if(findFragment == null){
                    findFragment = FindFragment.newInstance("发现");
                }
                transaction.replace(R.id.tb, findFragment);
                break;
            case 2:
                if(shopFragment == null){
                    shopFragment = ShopFragment.newInstance("逛一逛");
                }
                transaction.replace(R.id.tb, shopFragment);
                break;
            case 3:
                if(myFragment == null){
                    myFragment = MyFragment.newInstance("我的");
                }
                transaction.replace(R.id.tb, myFragment);
                break;
            default:
                break;
        }

        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
