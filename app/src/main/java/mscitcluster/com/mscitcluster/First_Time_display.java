package mscitcluster.com.mscitcluster;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.HashMap;

public class First_Time_display extends AppCompatActivity {
  public static HashMap<String,String> map;
    TabLayout tabLayout;
    ViewPager viewPager;
    FirstViewPagerAdapter firstViewPagerAdapter;
    //Toolbar toolbar1;
    //android.support.v4.app.FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__time_display);
        //toolbar1= (Toolbar) findViewById(R.id.first_time_tab);
        //setSupportActionBar(toolbar1);
        tabLayout=(TabLayout)findViewById(R.id.first_time_tab);
        viewPager=(NonSwipableViewPager)findViewById(R.id.first_time_viwepager);
        firstViewPagerAdapter= new FirstViewPagerAdapter(getSupportFragmentManager());
        firstViewPagerAdapter.addFragments(new login(),"");
        firstViewPagerAdapter.addFragments(new First(),"");
        firstViewPagerAdapter.addFragments(new second(),"");
        firstViewPagerAdapter.addFragments(new third(), "");
        viewPager.setAdapter(firstViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        map=new HashMap<>();

    }
    /*
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        //close();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();

    }*/
}
