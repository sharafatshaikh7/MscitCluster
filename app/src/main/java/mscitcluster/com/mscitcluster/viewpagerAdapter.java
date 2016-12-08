package mscitcluster.com.mscitcluster;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import layout.Syllabus;
import layout.upcoming_events;
import layout.Home_Fragment;

/**
 * Created by yasmeenshaikh on 3/18/2016.
 */
public class viewpagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> Title=new ArrayList<>();

    public void addFragments(Fragment fragments,String Title)
    {
        this.fragments.add(fragments);
        this.Title.add(Title);
    }


    public viewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0: return new Home_Fragment();
           // case 1: return new About_Fragment();
            case 1: return new upcoming_events();
            case 2: return new Syllabus();
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
                    return "Home";
                case 1 :
                    return "UpComing Lectures";
                case 2 :
                    return "Syllabus";
        }

        return null;
    }
}

