package layout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mscitcluster.com.mscitcluster.AnimatedExpandableListView;
import mscitcluster.com.mscitcluster.AnimatedExpandableListView.AnimatedExpandableListAdapter;
import mscitcluster.com.mscitcluster.R;
import mscitcluster.com.mscitcluster.myAdapter;

public class Home_Fragment extends Fragment {
    View hide_layout;
    AnimatedExpandableListView animatedExpandableListView;
    ExpandableListView expandableListView;
    ImageView imageView;
    Animation fadin,fadout;
    ViewFlipper viewFlipper;
    private int lastExpandedPosition = -1;//for list expand detection
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View homeview = inflater.inflate(R.layout.fragment_home_, container, false);

        hide_layout=(View)homeview.findViewById(R.id.homerelative_layout);


        //***************view Fliper****////////////////////
        viewFlipper= (ViewFlipper) homeview.findViewById(R.id.viewFlipper);

        fadin= AnimationUtils.loadAnimation(getActivity(), R.anim.fad_in);
        fadout=AnimationUtils.loadAnimation(getActivity(),R.anim.fade_out);

        imageView=(ImageView)homeview.findViewById(R.id.imageView6);

        viewFlipper.setInAnimation(fadin);
        viewFlipper.setOutAnimation(fadout);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();


        /**code for the expandable list view */
        expandableListView=(ExpandableListView)homeview.findViewById(R.id.expandableListView);

        List<String> Heading= new ArrayList<String>();

        List<String> sk=new ArrayList<String>();
        List<String> kj=new ArrayList<String>();
        List<String> mcc=new ArrayList<String>();
        List<String> kalker=new ArrayList<String>();
        List<String> birla=new ArrayList<String>();
        List<String> vikas=new ArrayList<String>();
        List<String> bandorkar=new ArrayList<String>();
        HashMap<String,List<String>> childlist=new HashMap<String,List<String>>();


        String heading_item[]=getResources().getStringArray(R.array.header_title);
        String sk1[]=getResources().getStringArray(R.array.sk_info);
        String kj1[]=getResources().getStringArray(R.array.kj_info);
        String mcc1[]=getResources().getStringArray(R.array.mcc_info);
        String kelkar1[]=getResources().getStringArray(R.array.kelkar_info);
        String birla1[]=getResources().getStringArray(R.array.birla_info);
        String vikas1[]=getResources().getStringArray(R.array.vikas_info);
        String bandorkar1[]=getResources().getStringArray(R.array.bandorkar_info);

        for(String title : heading_item)
        {
            Heading.add(title);

        }
        for(String title : sk1)
        {
            sk.add(title);
        }
        for(String title : kj1)
        {
            kj.add(title);
        }
        for(String title : mcc1)
        {
            mcc.add(title);
        }
        for(String title : kelkar1)
        {
            kalker.add(title);
        }
        for(String title : birla1)
        {
            birla.add(title);
         }
        for(String title : vikas1)
        {
            vikas.add(title);
        }
        for(String title : bandorkar1)
        {
            bandorkar.add(title);
        }

        childlist.put(Heading.get(0),sk);
        childlist.put(Heading.get(1), kj);
        childlist.put(Heading.get(2),mcc);
        childlist.put(Heading.get(3),kalker);
        childlist.put(Heading.get(4),birla);
        childlist.put(Heading.get(5), vikas);
        childlist.put(Heading.get(6), bandorkar);


        //final TextView textView=(TextView)homeview.findViewById(R.id.heading_item);
        myAdapter myAdapter=new myAdapter(getActivity(),Heading,childlist);
        expandableListView.setAdapter(myAdapter);
        expandableListView.setIndicatorBounds(630, 690);


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
                hide_layout.setVisibility(View.GONE);
            }

        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                hide_layout.setVisibility(View.VISIBLE);
            }
        });
        return homeview;
    }
}
