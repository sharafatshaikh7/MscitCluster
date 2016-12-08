package mscitcluster.com.mscitcluster;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class photo extends AppCompatActivity {

    Animation fadin,fadout;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);


        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
/*
        if(mFlipping==0){
            /** Start Flipping
            viewFlipper.startFlipping();
            mFlipping=1;
            //mButton.setText(R.string.str_btn_stop);
        }
        else{
            /** Stop Flipping
            viewFlipper.stopFlipping();
            mFlipping=0;
            //mButton.setText(R.string.str_btn_start);
        } */

        fadin= AnimationUtils.loadAnimation(this,R.anim.fad_in);
        fadout=AnimationUtils.loadAnimation(this,R.anim.fade_out);

        viewFlipper.setInAnimation(fadin);
        viewFlipper.setOutAnimation(fadout);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();

    }
}

