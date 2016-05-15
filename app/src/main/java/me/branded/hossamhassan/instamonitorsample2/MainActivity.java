package me.branded.hossamhassan.instamonitorsample2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brandedme.hossamhassan.instamonitor.InstaMonitor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnResetSessionsState,btnOpenSecondActivity,btnOpenFirstFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init views
        init();

    }

    private void init() {
        btnOpenSecondActivity=(Button)findViewById(R.id.btnOpen2ndActivity);
        btnOpenFirstFragment=(Button)findViewById(R.id.btnOpenFirstFragment);
        btnResetSessionsState=(Button)findViewById(R.id.btnResetSessionsState);
        btnOpenFirstFragment.setOnClickListener(this);
        btnOpenSecondActivity.setOnClickListener(this);
        btnResetSessionsState.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch(id)
        {
            case R.id.btnOpen2ndActivity:
                openSecondActivity();
                break;
            case R.id.btnOpenFirstFragment:
                openFirstFragment();
                break;
            case R.id.btnResetSessionsState:
                resetAllSessionsState();
                break;
        }

    }
    void resetAllSessionsState()
    {
        InstaMonitor.getInstance().resetSessionsState();
        Toast.makeText(MainActivity.this, "All sessions duration removed !", Toast.LENGTH_SHORT).show();
    }
    void openSecondActivity()
    {
        startActivity(new Intent(this,SecondActivity.class));
    }
    void openFirstFragment()
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack("First");
        ft.replace(R.id.main_container, new FragmentFirst(), "First").commit();
    }
}
