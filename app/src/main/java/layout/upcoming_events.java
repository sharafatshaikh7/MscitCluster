package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pushbots.push.Pushbots;

import mscitcluster.com.mscitcluster.R;
import mscitcluster.com.mscitcluster.customeHandler;


public class upcoming_events extends Fragment {

    TextView txtPushNotification;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View eventfour=inflater.inflate(R.layout.fragment_upcoming_events,container,false);
        Pushbots.sharedInstance().init(getActivity());
        Pushbots.sharedInstance().setCustomHandler(customeHandler.class);





        return eventfour;

    }

}
