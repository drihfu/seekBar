package com.a123.seekbar_0913_available;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener{

    private SeekBar mSeekBar;
    private TextView mTextView,mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();
    }

    private void initView(){
        mSeekBar=findViewById(R.id.id_seek_bar);
        mTextView=findViewById(R.id.id_text);
        mTextView2=findViewById(R.id.id_text2);

    }
    private void initData(){
        mTextView.setText(R.string.normal);
        mTextView2.setText(R.string.middle);
    }
    private void initEvent(){
        mSeekBar.setOnSeekBarChangeListener(this);
    }

    //我的习惯，在Activity后面implements点击事件，然后在类中处理
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (i){
            case 0:
                mTextView2.setText(R.string.low);
                Drawable drawable=getResources().getDrawable(R.drawable.device_control_green_low_img);
                seekBar.setThumb(drawable);
                break;
            case 1:
                mTextView2.setText(R.string.middle);
                Drawable drawable1=getResources().getDrawable(R.drawable.device_control_yellow_mid_img);
                seekBar.setThumb(drawable1);
                break;
            case 2:
                mTextView2.setText(R.string.high);
                Drawable drawable2=getResources().getDrawable(R.drawable.device_control_red_high_img);
                seekBar.setThumb(drawable2);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        mTextView.setText(R.string.press);

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mTextView.setText(R.string.normal);

    }


}
