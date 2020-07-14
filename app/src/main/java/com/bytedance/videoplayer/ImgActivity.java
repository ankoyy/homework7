package com.bytedance.videoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImgActivity extends AppCompatActivity {

    private Button loadBtn;
    private ImageView loadImg;
    private String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562328963756&di=9c0c6c839381c8314a3ce8e7db61deb2&imgtype=0&src=http%3A%2F%2Fpic13.nipic.com%2F20110316%2F5961966_124313527122_2.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("使用Glide展示网络图片");
        setContentView(R.layout.activity_img);
        initAll();
    }

    private void initAll(){
        loadBtn = findViewById(R.id.loadImgBtn);
        loadImg = findViewById(R.id.imageView);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestOptions cropOptions = new RequestOptions();
                //实现图片圆角
                cropOptions = cropOptions.circleCrop();
                Glide.with(ImgActivity.this)
                        .load(url)
                        .apply(cropOptions)
                        .placeholder(R.drawable.jiazaizhong)
                        .error(R.drawable.jiazaishibai)
                        .fallback(R.drawable.weizhaodao)
                        .transition(withCrossFade(2000))
                        .into(loadImg);
            }
        });
    }
}
