package com.feicui.edu.newsapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.feicui.edu.newsapp.R;
import com.feicui.edu.newsapp.base.adapter.MyBaseAdapter;
import com.feicui.edu.newsapp.entity.News;

/**
 * Created by Administrator on 2016/10/25 0025.
 */
public class NewsListAdapter extends MyBaseAdapter<News> {
    @Override
    public View getMyView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null){
            vh = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_list_news, null);
            vh.imageView = (ImageView) convertView.findViewById(R.id.item_list_news_iv);
            vh.textView1 = (TextView) convertView.findViewById(R.id.item_list_news_tv1);
            vh.textView2 = (TextView) convertView.findViewById(R.id.item_list_news_tv2);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.imageView.setImageResource(R.drawable.cccc);
        //获取数据
        News news = infos.get(position);
        vh.textView1.setText(news.getTitle());
        vh.textView2.setText(news.getSummary());
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView1, textView2;
    }
}
