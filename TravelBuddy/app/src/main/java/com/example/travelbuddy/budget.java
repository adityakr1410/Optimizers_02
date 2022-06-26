package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class budget extends AppCompatActivity {

    int tot_val;
    int rem_val;
    int htl_val;
    int res_val;
    int trave_val;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        Button btn = findViewById(R.id.btn_update);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {

                                       update();
                                   }
                               }
        );

    }


    private void update()
    {

        try {
            EditText t_txt = (EditText) findViewById(R.id.tot_amt_edText);
            EditText r_txt = (EditText) findViewById(R.id.rem_amt_edText);
            EditText htl_amt = (EditText) findViewById(R.id.u_htls_edText);
            EditText res_amt = (EditText) findViewById(R.id.u_res_edText);
            EditText travel_amt = (EditText) findViewById(R.id.u_travel_edText);

            Button f_up = (Button) findViewById(R.id.btn_update);
            SeekBar s_htls = (SeekBar) findViewById(R.id.seekBar_htls);
            SeekBar s_res = (SeekBar) findViewById(R.id.seekBar_res);
            SeekBar s_travel = (SeekBar) findViewById(R.id.seekBar_trav);

            int tot_val = Integer.parseInt(t_txt.getText().toString());
//            int rem_val = Integer.parseInt(r_txt.getText().toString());
            int htl_val = Integer.parseInt(htl_amt.getText().toString());
            int res_val = Integer.parseInt(res_amt.getText().toString());
            int travel_val = Integer.parseInt(travel_amt.getText().toString());

            if (htl_val + res_val + trave_val > tot_val) {
                Toast.makeText(getApplicationContext(), "ERROR! User must increase Total amount to avail this plan", Toast.LENGTH_SHORT).show();
                return;
            }

            //r_txt.setText(tot_val - (htl_val + res_val +travel_val));

            s_htls.setMax(tot_val);
            s_res.setMax(tot_val);
            s_travel.setMax(tot_val);

            s_htls.setProgress(htl_val);
            s_res.setProgress(res_val);
            s_travel.setProgress(travel_val);
        } catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Enter all details correctly ", Toast.LENGTH_SHORT).show();
        }

    }
}