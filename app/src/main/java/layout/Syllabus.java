package layout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mscitcluster.com.mscitcluster.R;


public class Syllabus extends Fragment {

    Button btn_syl_1,btn_dm,btn_ds,btn_dat,btn_st,btn_mc,btn_cc,btn_acn,btn_adbms;
    Button btn_syl_2,btn_es,btn_eh,btn_ism,btn_vr,btn_ai,btn_cf,btn_itim,btn_cm;
    Button btn_result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View syllabus_view = inflater.inflate(R.layout.fragment_syllabus, container, false);

        //**********************initialize a buttons*****////////

        btn_syl_1=(Button)syllabus_view.findViewById(R.id.btn_part_one_link);
        btn_dm=(Button)syllabus_view.findViewById(R.id.btn_dm);
        btn_ds=(Button)syllabus_view.findViewById(R.id.btn_ds);
        btn_dat=(Button)syllabus_view.findViewById(R.id.btn_dat);
        btn_st=(Button)syllabus_view.findViewById(R.id.btn_st);
        btn_mc=(Button)syllabus_view.findViewById(R.id.btn_mc);
        btn_cc=(Button)syllabus_view.findViewById(R.id.btn_cc);
        btn_acn=(Button)syllabus_view.findViewById(R.id.btn_acn);
        btn_adbms=(Button)syllabus_view.findViewById(R.id.btn_adbms);

        btn_syl_2=(Button)syllabus_view.findViewById(R.id.btn_part_one_link);
        btn_es=(Button)syllabus_view.findViewById(R.id.btn_es);
        btn_eh=(Button)syllabus_view.findViewById(R.id.btn_eh);
        btn_ism=(Button)syllabus_view.findViewById(R.id.btn_ism);
        btn_vr=(Button)syllabus_view.findViewById(R.id.btn_vr);
        btn_ai=(Button)syllabus_view.findViewById(R.id.btn_ai);
        btn_cf=(Button)syllabus_view.findViewById(R.id.btn_cf);
        btn_itim=(Button)syllabus_view.findViewById(R.id.btn_itim);
        btn_cm=(Button)syllabus_view.findViewById(R.id.btn_cm);

        btn_result=(Button)syllabus_view.findViewById(R.id.btn_result_link);

/////*********************************All Button Events*************************/////////////////////////////

        btn_syl_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://archive.mu.ac.in/syllabus/4.133%20MSc%20IT%20Sem%20I%20and%20II.pdf"));
                startActivity(viewIntent);

            }
        });

        btn_dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszUXJ4TVFaN0l6VWs/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszU19sdEprSGZ1Vzg/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_dat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszZlFTWU1ldlRTdEk/view?usp=sharing"));
                startActivity(viewIntent);
            }
        });

        btn_st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszbU1UN1dSVW94RzQ/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszZzZnOVFPcV8xdXM/view?usp=sharing"));
                startActivity(viewIntent);
            }
        });

        btn_cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszSlBqNWhkMzhyWWc/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_acn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszU2VGVkd2clY3RFk/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_adbms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszZGluTXZFOGRVU1U/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_syl_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://archive.mu.ac.in/syllabus/4.130%20MSC%20IT%20Sem%20III%20and%20IV.pdf"));
                startActivity(viewIntent);

            }
        });

        btn_es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszM0g2TEwzSWZxcW8/view?usp=sharing"));
                startActivity(viewIntent);
            }
        });

        btn_eh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszcF9nVmJoTlZIdUE/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_ism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszSkRZeUViRkZFWjA/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszMjljR0E2cGFrVXM/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszT2p4VmRCMGVKd28/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszX2JwNXJjVUNhVDA/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_itim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszVW1ZZFBMdXhOQXM/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://drive.google.com/file/d/0B60AikEqFFszNmh4dGNySWZSNm8/view?usp=sharing"));
                startActivity(viewIntent);

            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://mu.ac.in/portal/circular-for-permanent-employees/revised-syllabus-3/revised-syllabus-science/"));
                startActivity(viewIntent);

            }
        });
        return syllabus_view;
    }
}
