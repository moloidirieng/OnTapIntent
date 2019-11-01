package a.mt.ontapintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnChuyenManHinh;
    EditText edtNhapA,edtNhapB;
    TextView  tvKetQua;
    int a,b,kq;
    private static final int gui=100,tra=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        btnChuyenManHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyChuyenManHinh();
               // xuLyChuyenDulieuBundle();

            }
        });
    }

    private void xuLyChuyenDulieuBundle() {
        a=Integer.parseInt(edtNhapA.getText().toString());
        b=Integer.parseInt(edtNhapB.getText().toString());

        Intent intent=new Intent(MainActivity.this,Manhinh2Activity.class);
        Bundle bundle=new Bundle();
        bundle.putInt("A",a);
        bundle.putInt("B",b);
        intent.putExtra("ABC",bundle);
        startActivityForResult(intent,gui);
    }

    private void addControls() {
        btnChuyenManHinh=findViewById(R.id.btnChuyen);
        edtNhapA=findViewById(R.id.edtNhapA);
        edtNhapB=findViewById(R.id.edtNhapB);
        tvKetQua=findViewById(R.id.tvKetQua);
    }

    private void xulyChuyenManHinh() {
        a=Integer.parseInt(edtNhapA.getText().toString());
        b=Integer.parseInt(edtNhapB.getText().toString());

        Intent intent=new Intent(MainActivity.this,Manhinh2Activity.class);
        intent.putExtra("A",a);
        intent.putExtra("B",b);
        startActivityForResult(intent,gui);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {



        super.onActivityResult(requestCode, resultCode, data);
        if(gui==requestCode&resultCode==tra){
            kq=data.getIntExtra("KQ",0);
            tvKetQua.setText("Tổng "+a+" + "+b+" = "+kq);

        }
    }
}
