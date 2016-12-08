package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mscitcluster.com.mscitcluster.Epand_faculties;
import mscitcluster.com.mscitcluster.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class feculties extends Fragment {
    ExpandableListView expandableListView;
    private int lastExpandedPosition = -1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View faculties= inflater.inflate(R.layout.fragment_feculties, container, false);

        expandableListView=(ExpandableListView)faculties.findViewById(R.id.expandableListViewfaculties);

        List<String> Heading1= new ArrayList<String>();
        List<String> rp=new ArrayList<String>();
        List<String> hd=new ArrayList<String>();
        List<String> p=new ArrayList<String>();
        HashMap<String,List<String>> childlist1=new HashMap<String,List<String>>();



        String heading_item[]=getResources().getStringArray(R.array.fac_heading);
        String rp1[]=getResources().getStringArray(R.array.patel);
        String hd1[]=getResources().getStringArray(R.array.hiren);
        String p1[]=getResources().getStringArray(R.array.pornima);


        for(String title : heading_item)
        {
            Heading1.add(title);

        }
        for(String title : rp1)
        {
            rp.add(title);
        }
        for(String title : hd1)
        {
            hd.add(title);
        }
        for(String title : p1)
        {
            p.add(title);
        }

        childlist1.put(Heading1.get(0),rp);
        childlist1.put(Heading1.get(1), hd);
        childlist1.put(Heading1.get(2), p);

        Epand_faculties epand_faculties=new Epand_faculties(getActivity(),Heading1,childlist1);
        expandableListView.setAdapter(epand_faculties);
        expandableListView.setIndicatorBounds(630, 690);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }

        });

        return faculties;
    }
}
