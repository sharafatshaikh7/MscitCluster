package layout;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mscitcluster.com.mscitcluster.R;
import mscitcluster.com.mscitcluster.viewpagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    viewpagerAdapter viewpagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View home= inflater.inflate(R.layout.fragment_home, container, false);

        tabLayout = (TabLayout)home.findViewById(R.id.tablayout);
        viewPager = (ViewPager)home.findViewById(R.id.viewpager);
        viewpagerAdapter = new viewpagerAdapter(getFragmentManager());
        viewpagerAdapter.addFragments(new Home_Fragment(), "Home");
        viewpagerAdapter.addFragments(new upcoming_events(), "UpComing Lectures");
        viewpagerAdapter.addFragments(new Syllabus(), "syllabus");
        viewPager.setAdapter(viewpagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return home;
    }

}
