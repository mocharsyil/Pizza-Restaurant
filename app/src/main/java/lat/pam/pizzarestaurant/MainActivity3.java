package lat.pam.pizzarestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String city = intent.getStringExtra("city");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textView = (TextView) findViewById(R.id.user_name);
        textView.setText(userName);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    }
}