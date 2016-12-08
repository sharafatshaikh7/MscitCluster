package mscitcluster.com.mscitcluster;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class login extends Fragment {
    TextView txtlognin_name,txtlogin_pass,txtlogin_hint;
    Button btn_login,btn_registration;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View loginview= inflater.inflate(R.layout.fragment_login, container, false);
        txtlognin_name=(TextView)loginview.findViewById(R.id.txt_login_username);
        txtlogin_pass=(TextView)loginview.findViewById(R.id.txt_login_password);
        txtlogin_hint=(TextView)loginview.findViewById(R.id.login_attempt_show);
        btn_login=(Button)loginview.findViewById(R.id.btn_login);
        btn_registration=(Button)loginview.findViewById(R.id.btn_registration);
        txtlogin_hint.setText("3");

        btn_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.first_time_viwepager);
                viewPager.setCurrentItem(1);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtlognin_name.length() <= 0){
                    txtlognin_name.setError("Enter Username");
                }else
                {
                    if(txtlogin_pass.length() <= 0){
                        txtlogin_pass.setError("Enter Password");
                    }else
                    {
                        String name=txtlognin_name.getText().toString();
                        String password=txtlogin_pass.getText().toString();
                        int hint=Integer.parseInt(txtlogin_hint.getText().toString());
                        String method="login";
                        BackgroundTask backgroundTask=new BackgroundTask(getActivity());
                        backgroundTask.execute(method, name, password);

                        //startActivity(new Intent(getActivity(), MainActivity.class));

                        if(backgroundTask.alertDialog.toString().equals("Login Failed....Try Again"))
                        {
                            hint--;
                            if(hint == 0)
                            {
                                getActivity().finish();
                            }

                        }else
                        {
                            Intent intent=new Intent(getActivity(),MainActivity.class);
                            startActivity(intent);
                        }


                    }
                }
            }
        });

        return loginview;
    }
}
