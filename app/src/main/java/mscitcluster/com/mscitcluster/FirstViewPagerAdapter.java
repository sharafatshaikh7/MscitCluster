package mscitcluster.com.mscitcluster;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by yasmeenshaikh on 4/19/2016.
 */
public class FirstViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> Title=new ArrayList<>();

    public void addFragments(Fragment fragments,String Title)
    {
        this.fragments.add(fragments);
        this.Title.add(Title);
    }

    public FirstViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new login();
            case 1: return new First();
            case 2: return new second();
            case 3: return new third();
        }

        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0 :
                return "";
            case 1 :
                return "";
            case 2 :
                return "";
            case 3:
                return "";
        }

        return null;
    }
}
