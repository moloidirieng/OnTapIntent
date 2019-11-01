package a.mt.ontapintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Manhinh2Activity extends AppCompatActivity {
    Button btnVeManTruoc;
    TextView tvNhan;
    Intent intent;
    int a,b;
    int tra=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh2);
        btnVeManTruoc=findViewById(R.id.btnVeManTruoc);
        tvNhan=findViewById(R.id.tvShow);
        xuLyNhan();


        btnVeManTruoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyVeManTruoc();
            }
        });

    }

    private void xuLyNhan() {
        intent=getIntent();
        a=intent.getIntExtra("A",0);
        b=intent.getIntExtra("B",0);
        tvNhan.setText(" Tổng :" +a+" + "+b+ " = "+(a+b));

    }


    private void xuLyVeManTruoc() {
        intent.putExtra("KQ",(a+b));
        setResult(tra,intent);

        this.finish();
    }
}
