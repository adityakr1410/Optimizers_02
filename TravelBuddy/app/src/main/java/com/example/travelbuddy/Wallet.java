package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class Wallet extends AppCompatActivity implements PaymentResultListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    Button paywith;
    TextView paystatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet);
        Checkout.preload(getApplicationContext());
        paywith=findViewById(R.id.paywith);
        paystatus=findViewById(R.id.paystatus);
        paywith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaymentNow("100");
            }
        });
    }

    private void PaymentNow(String amount) {
        final Activity activity=this;
        Checkout checkout=new Checkout();
        checkout.setKeyID("rzp_test_2aZF5btnCrTZpy");
        checkout.setImage(R.drawable.ic_launcher_background);
        double finalAmount= Float.parseFloat(amount)*100;
        try {
            JSONObject options = new JSONObject();

            options.put("name", "Optimisers");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "50000");//pass amount in currency subunits
            options.put("prefill.email", "optimisers.rocks@example.com");
            options.put("prefill.contact","9988776655");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }

}

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        paystatus.setText(s);
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Failed.Try Again", Toast.LENGTH_SHORT).show();
        paystatus.setText(s);
    }
}