package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import mscitcluster.com.mscitcluster.FeedBackDataEntry;
import mscitcluster.com.mscitcluster.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class feedback extends Fragment {
    EditText feedback_name,email,suggestion;
    String f_b_name,f_b_email,f_b_suggestion;
    RatingBar ratingBar;
    String rating;
    int rating1;
    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View feedback= inflater.inflate(R.layout.fragment_feedback, container, false);

        feedback_name=(EditText)feedback.findViewById(R.id.feedback_name);
        email=(EditText)feedback.findViewById(R.id.feedback_email);
        suggestion=(EditText)feedback.findViewById(R.id.feedback_suggestion);
        ratingBar=(RatingBar)feedback.findViewById(R.id.ratingBar);
        submit=(Button)feedback.findViewById(R.id.feedback_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(feedback_name.length() <= 0){
                    feedback_name.setError("Enter proper Name");
                }else{
                    if(email.length() <= 0) {
                        email.setError("Enter proper Email id");
                    }else{
                        if(suggestion.length() <= 30){
                            suggestion.setError("Enter Atlease 30 charescter");
                        }else
                        {
                            f_b_name=feedback_name.getText().toString();
                            f_b_email=email.getText().toString();
                            f_b_suggestion=suggestion.getText().toString();
                            rating=String.valueOf(ratingBar.getRating());

                            String method="register";
                            FeedBackDataEntry feedBackDataEntry=new FeedBackDataEntry(getActivity());
                            feedBackDataEntry.execute(method, f_b_name, f_b_email, f_b_suggestion, rating);
                            dataclear();
                            getActivity().finish();
                        }
                    }
                }
            }
        });


        return feedback;
    }
    public void dataclear()
    {
        feedback_name.setText("");
        email.setText("");
        suggestion.setText("");
    }

}
