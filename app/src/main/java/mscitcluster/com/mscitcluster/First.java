package mscitcluster.com.mscitcluster;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import mscitcluster.com.mscitcluster.First_Time_display;


public class First extends Fragment {

    Button btn;
    EditText txtname,txtnumber,txtemail,txtpass,txt_confirm_pass;
    String name,mobile,email,pass,confirm_pass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View firstview = inflater.inflate(R.layout.fragment_first, container, false);


        btn=(Button)firstview.findViewById(R.id.btn_start_page_next);
        txtname= (EditText) firstview.findViewById(R.id.txt_start_name);
        txtnumber=(EditText)firstview.findViewById(R.id.txt_start_number);
        txtemail=(EditText)firstview.findViewById(R.id.txt_start_email);
        txtpass=(EditText)firstview.findViewById(R.id.txt_start_pass);
        txt_confirm_pass=(EditText)firstview.findViewById(R.id.txt_start_confirm_pass);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtname.length() <= 0){
                    txtname.setError("Enter Name");
                }else{
                    if(txtnumber.length() < 10) {
                        txtnumber.setError("Enter Only 10 Digit in Number");
                    }else{
                        if(txtemail.length() <= 0){
                            txtemail.setError("Enter Proper Email id");
                        }else{
                            if(txtpass.length() < 10 ) {
                                txtpass.setError("Enter Only 10 digit password");

                            }else{
                                   if(txtpass.getText().toString().equals(txt_confirm_pass.getText().toString())) {

                                       name = txtname.getText().toString();
                                       mobile = txtnumber.getText().toString();
                                       email = txtemail.getText().toString();
                                       pass = txtpass.getText().toString();
                                       confirm_pass = txt_confirm_pass.getText().toString();
                                       ///*********puting a data on a interface**//
                                       First_Time_display.map.put(Constants.studenet_basic_details.name,name);
                                       First_Time_display.map.put(Constants.studenet_basic_details.mobile,mobile);
                                       First_Time_display.map.put(Constants.studenet_basic_details.email,email);
                                       First_Time_display.map.put(Constants.studenet_basic_details.pass,pass);
                                       First_Time_display.map.put(Constants.studenet_basic_details.confirm_pass,confirm_pass);
                                       //*****click on button jump on net fragment**//

                                       ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.first_time_viwepager);
                                       viewPager.setCurrentItem(2);
                                   }else
                                   {
                                       txt_confirm_pass.setError("password not matche");
                                   }
                                }
                             }

                        }

                    }

                }
        });

        return firstview;
    }
}
