package lat.pam.pizzarestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity3 extends AppCompatActivity {
    TextView peperoni_description, spaghetti_description, burger_description, steak_description;
    ProgressDialog loading;

    private Toolbar toolbar;

    private void tampilData() {
        loading = ProgressDialog.show(MainActivity3.this, "Memuat Data", "Mohon Tunggu...");
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://retoolapi.dev/StWODX/uasresto";
        JSONObject jsonObject = new JSONObject();
        final String requestBody = jsonObject.toString();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jo = new JSONArray(response);
                    Log.d("pepperoni", jo.getJSONObject(0).getString("details"));
                    String peperoni = jo.getJSONObject(0).getString("details");
                    peperoni_description.setText(peperoni);
                    loading.cancel();

                    Log.d("spaghetti", jo.getJSONObject(1).getString("details"));
                    String spaghetti = jo.getJSONObject(1).getString("details");
                    spaghetti_description.setText(spaghetti);
                    loading.cancel();

                    Log.d("burger", jo.getJSONObject(2).getString("details"));
                    String burger = jo.getJSONObject(2).getString("details");
                    burger_description.setText(burger);
                    loading.cancel();

                    Log.d("steak", jo.getJSONObject(3).getString("details"));
                    String steak = jo.getJSONObject(3).getString("details");
                    steak_description.setText(steak);
                    loading.cancel();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.cancel();
                Toast.makeText(MainActivity3.this, "Gagal mengambil Rest Api" + error, Toast.LENGTH_SHORT).show();
            }
        }
        );
        queue.add(stringRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String city = intent.getStringExtra("city");
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);

//        TextView textView = (TextView) findViewById(R.id.user_name);
//        textView.setText(userName);
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        View pepperoni = findViewById(R.id.pepperoni);
        pepperoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("userName", userName);
                intent.putExtra("city", city);
                intent.putExtra("pizza", "Pepperoni Pizza");
                intent.putExtra("price", "Rp. 100.000");
                intent.putExtra("description", "Pepperoni pizza adalah pizza yang memiliki  topping daging pepperoni sapi asli. Di Italia, pepperoni disebut salame piccante (salami panas). Biasa menjadi bahan baku pizza di Amerika Serikat, yang sering mewakili 30% pelengkap. Pizza ini cocok untuk santap siang ataupun malam anda");
                startActivity(intent);
            }
        });

        View spaghetti = findViewById(R.id.spaghetti);
        spaghetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("userName", userName);
                intent.putExtra("city", city);
                intent.putExtra("pizza", "Spaghetti");
                intent.putExtra("price", "Rp. 80.000");
                intent.putExtra("description", "Spaghetti merupakan salah satu dari varian pasta yang memiliki bentuk silinder tipis dan padat yang terbuat dari olahan gandum. Spaghetti telah menjadi makanan pokok tradisional penduduk Italia.");
                startActivity(intent);
            }
        });

        View burger = findViewById(R.id.burger);
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("userName", userName);
                intent.putExtra("city", city);
                intent.putExtra("pizza", "Burger");
                intent.putExtra("price", "Rp. 50.000");
                intent.putExtra("description", "Burger adalah makanan yang terbuat dari daging sapi yang dibentuk menjadi bentuk bulat dan digoreng. Burger biasanya disajikan dengan bahan tambahan seperti keju, tomat, selada, dan saus.");
                startActivity(intent);
            }
        });

        View steak = findViewById(R.id.steak);
        steak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("userName", userName);
                intent.putExtra("city", city);
                intent.putExtra("pizza", "Steak");
                intent.putExtra("price", "Rp. 150.000");
                intent.putExtra("description", "Steak adalah daging sapi yang dipotong tipis dan digoreng. Steak biasanya disajikan dengan bahan tambahan seperti keju, tomat, selada, dan saus.");
                startActivity(intent);
            }
        });

        tampilData();
    }
}