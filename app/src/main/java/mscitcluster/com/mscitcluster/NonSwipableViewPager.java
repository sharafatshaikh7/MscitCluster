package mscitcluster.com.mscitcluster;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by yasmeenshaikh on 4/20/2016.
 */
public class NonSwipableViewPager extends ViewPager{
    public NonSwipableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NonSwipableViewPager(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        return false;
    }
}
