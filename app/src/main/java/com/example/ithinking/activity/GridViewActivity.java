package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.ithinking.R;

public class GridViewActivity extends AppCompatActivity {
    private int[] arrayPicture = new int[]{
            R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,R.mipmap.img04,
            R.mipmap.img05,R.mipmap.img06,R.mipmap.img07,R.mipmap.img08,
            R.mipmap.img09,R.mipmap.img10,R.mipmap.img11,R.mipmap.img12,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter{

        private Context mContext;
        public ImageAdapter(Context context){
            mContext = context;
        }
        @Override
        public int getCount() {
            return arrayPicture.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView imageView;
            if(view == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT,GridView.LayoutParams.MATCH_PARENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }else {
                imageView = (ImageView)view;
            }
            imageView.setImageResource(arrayPicture[position]);
            return imageView;
        }
    }
}
