package mscitcluster.com.mscitcluster;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;


public class second extends Fragment {
    Button btn;
    Button btn_select_image;
    Spinner dropdown,dropdown1;
    ImageView imageview;
    private RadioButton rd_btn1,rd_btn2,rd_btn3;
    public static final int GET_FROM_GALLERY = 3;
    Bitmap bitmap;
    student_data sd;
    String college,part;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View secondview=inflater.inflate(R.layout.fragment_second, container, false);
        btn = (Button)secondview.findViewById(R.id.btn_page_second_next);
        btn_select_image = (Button)secondview.findViewById(R.id.btn_page_second_profile_choser);
        imageview=(ImageView)secondview.findViewById(R.id.page_second_profile_pic);
        dropdown = (Spinner)secondview.findViewById(R.id.spinner_college);
        dropdown1 = (Spinner)secondview.findViewById(R.id.spinner_part);

        String[] colleges = new String[]{"Select College","S.K. Somaiya", "K.J Somaiya", "MCC College","Kelkar College","Birla College","Vikas College","Bandorkar College"};
        ArrayAdapter<String> college_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, colleges);
        dropdown.setAdapter(college_adapter);

        String[] parts = new String[]{"Select Part","Part 1","Part 2"};
        ArrayAdapter<String> part_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, parts);
        dropdown1.setAdapter(part_adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dropdown.getSelectedItemPosition() == 0) {
                    ((TextView) dropdown.getSelectedView()).setError("Select College");
                }else{
                    if(dropdown1.getSelectedItemPosition() == 0)
                    {
                        ((TextView) dropdown1.getSelectedView()).setError("Select Part");
                    }else
                    {
                        college=(String)dropdown.getSelectedItem();
                        part=(String)dropdown1.getSelectedItem();

                        First_Time_display.map.put(Constants.studenet_basic_details.college,college);
                        First_Time_display.map.put(Constants.studenet_basic_details.part,part);

                        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.first_time_viwepager);
                        viewPager.setCurrentItem(3);
                    }
                }
            }
        });


        btn_select_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);

            }
        });

        return secondview;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imageview.setImageBitmap(bitmap);
        }
    }
}
