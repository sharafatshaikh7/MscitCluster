package mscitcluster.com.mscitcluster;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class third extends Fragment {
    Button btn;
   // TextView user_name,user_number;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View thirdview=inflater.inflate(R.layout.fragment_third, container, false);
        btn=(Button)thirdview.findViewById(R.id.btn_page_last_started);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1=First_Time_display.map.get(Constants.studenet_basic_details.name);
                String mobile1=First_Time_display.map.get(Constants.studenet_basic_details.mobile);
                String email1=First_Time_display.map.get(Constants.studenet_basic_details.email);
                String pass1=First_Time_display.map.get(Constants.studenet_basic_details.pass);
                String confirm_pass1=First_Time_display.map.get(Constants.studenet_basic_details.confirm_pass);
                String college1=First_Time_display.map.get(Constants.studenet_basic_details.college);
                String part1=First_Time_display.map.get(Constants.studenet_basic_details.part);
                String image="Not Taken";

                String method="register";
                BackgroundTask backgroundTask=new BackgroundTask(getActivity());
                backgroundTask.execute(method, name1, mobile1, email1, pass1, confirm_pass1, college1, part1, image);

                Intent intent=new Intent(getActivity(),MainActivity.class);
                //intent.putExtra("name",name1);
                //intent.putExtra("number",mobile1);
                startActivity(intent);
                getActivity().finish();

            }
        });

        return thirdview;
    }
}