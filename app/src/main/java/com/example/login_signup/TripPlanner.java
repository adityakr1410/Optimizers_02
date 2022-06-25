package com.example.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class TripPlanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_planner);


    }

    EditText t_txt = (EditText)findViewById(R.id.tot_amt_edText);
    EditText r_txt = (EditText)findViewById(R.id.rem_amt_edText);
    EditText htl_amt = (EditText)findViewById(R.id.u_htls_edText);
    EditText res_amt = (EditText)findViewById(R.id.u_res_edText);
    EditText trav_amt = (EditText)findViewById(R.id.u_travel_edText);

    Button f_up = (Button) findViewById(R.id.btn_update);
    SeekBar s_htls = (SeekBar) findViewById(R.id.seekBar_htls);
    SeekBar s_res = (SeekBar) findViewById(R.id.seekBar_res);
    SeekBar s_travel = (SeekBar) findViewById(R.id.seekBar_trav);

    Button btn = findViewById(R.id.budget_pg_btn);



    public void update()
    {
        int tot_val  = Integer.parseInt(t_txt.getText().toString());
        int rem_val = Integer.parseInt(r_txt.getText().toString());
        int htl_val = Integer.parseInt(htl_amt.getText().toString());
        int res_val = Integer.parseInt(res_amt.getText().toString());
        int trav_val = Integer.parseInt(trav_amt.toString().toString());

        if ( htl_val + res_val + trav_val > tot_val)
        {
            Toast.makeText(getApplicationContext(),"ERROR! User must increase Total amount to avail this plan",Toast.LENGTH_SHORT).show();
            return;
        }

        s_htls.setMax(tot_val);
        s_res.setMax(tot_val);
        s_travel.setMax(tot_val);

        s_htls.setProgress(htl_val);
        s_res.setProgress(res_val);
        s_travel.setProgress(trav_val);

    }

}