package mscitcluster.com.mscitcluster;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yasmeenshaikh on 3/25/2016.
 */
public class Epand_faculties extends BaseExpandableListAdapter {

    ImageView imageView,imageView1;
    private List<String> header_title;
    private HashMap<String,List<String>> child_title;
    private Context ctx;

    public Epand_faculties(Context ctx, List<String> header_title, HashMap<String, List<String>> child_title)
    {
        this.ctx=ctx;
        this.child_title=child_title;
        this.header_title=header_title;
    }


    @Override
    public int getGroupCount() {
        return header_title.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child_title.get(header_title.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return header_title.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return child_title.get(header_title.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title =(String)this.getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.faculties_group,null);

        }
        TextView textView=(TextView)convertView.findViewById(R.id.fec_group);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);



//***********use for change a color***///////////
        if(isExpanded)
            textView.getResources().getDrawable(R.drawable.parent_txt_expand);
        else
            //textView.setBackgroundColor(ctx.getResources().getColor(R.color.exp_parent_collpsed));
            textView.getResources().getDrawable(R.drawable.image_corner);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title=(String)this.getChild(groupPosition,childPosition);
        if(convertView == null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.faculties_child,null);
        }
        TextView textView=(TextView)convertView.findViewById(R.id.fac_child);
        textView.setText(title);
        //((ImageView)convertView.findViewById(R.id.imageView6)).setImageDrawable((Drawable) ((sk<String, Object>) getChild(groupPosition, childPosition)).get(sk));
//****** aasing image for child group*******************//
        //String name= (String) textView.getText();
       // imageView=(ImageView)convertView.findViewById(R.id.imageView7);
        imageView1=(ImageView)convertView.findViewById(R.id.imageView8);
        if(groupPosition==0)
        {
            //imageView.setImageResource(R.drawable.image1);
            imageView1.setImageResource(R.drawable.image1);
        }
        if(groupPosition==1)
        {
            //imageView.setImageResource(R.drawable.image2);
            imageView1.setImageResource(R.drawable.image2);
        }
        if(groupPosition==2)
        {
            //imageView.setImageResource(R.drawable.image3);
            imageView1.setImageResource(R.drawable.image3);

        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
