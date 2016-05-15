package me.branded.hossamhassan.instamonitorsample2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.brandedme.hossamhassan.instamonitor.Fragment.InstaFragmentS4;

/**
 * Created by Hossam on 5/12/2016.
 */
public class FragmentFirst extends InstaFragmentS4 implements View.OnClickListener {
    ImageButton btnExit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        btnExit = (ImageButton) view.findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnExit)
            getActivity().onBackPressed();


    }
}
