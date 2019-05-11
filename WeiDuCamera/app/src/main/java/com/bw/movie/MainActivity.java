package com.bw.movie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.view.SecondActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.yidaoye_image)
    ImageView yidaoyeImage;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.qidongye_text1)
    TextView qidongyeText1;
    @BindView(R.id.qidongye_text2)
    TextView qidongyeText2;
    private SharedPreferences sp;
    private int i=5;
    private Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            tv.setText(i+"s");
            if(i==0){
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("flag",true);
                edit.commit();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                finish();
            }
            i--;
            handler.sendEmptyMessageDelayed(0, 1000);
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //获取sp对象
        sp=getSharedPreferences("config", MODE_PRIVATE);
        //取值
        boolean flag = sp.getBoolean("flag", false);
        if(flag){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
            finish();
        }else{
            handler.sendEmptyMessage(0);
        }
    }
}
