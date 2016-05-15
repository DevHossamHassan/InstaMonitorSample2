package me.branded.hossamhassan.instamonitorsample2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brandedme.hossamhassan.instamonitor.InstaMonitor;
import com.brandedme.hossamhassan.instamonitor.model.Session;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<Session> sessionsList;
    Button btnGetData;
    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //bind Views
        init();
        btnGetData.setOnClickListener(this);


    }
    void init()
    {
        tvData=(TextView)findViewById(R.id.tvDataMap);
        btnGetData=(Button) findViewById(R.id.btnGetData);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if (id==R.id.btnGetData)
            setDataToViews();
    }

    void setDataToViews()
    {
        sessionsList =getInstaMonitorData();
        if (sessionsList != null) {
            for (Session session : sessionsList) {
                String data = tvData.getText() + session.getShortName() + "\t" + session.getTime()+"\n";
                tvData.setText(data);
            }
        } else
            tvData.setText("Null");
    }

    ArrayList<Session> getInstaMonitorData()
    {
        return  InstaMonitor.getInstance().getMonitorData();
    }
}
