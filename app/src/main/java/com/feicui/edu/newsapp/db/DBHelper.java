package com.feicui.edu.newsapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.feicui.edu.newsapp.entity.News;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/25 0025.
 */
public class DBHelper {

    private DBOpenHelper helper;
    private SQLiteDatabase db;

    public DBHelper(Context context){
        if (helper == null){
            helper = new DBOpenHelper(context);
        }
        db = helper.getWritableDatabase();
    }

//    添加数据到数据库
    public void addNews(ArrayList<News> datas){
        //打开数据库
        db = helper.getWritableDatabase();
        for (News news : datas) {
            ContentValues cv = new ContentValues();
//nid integer,title text,summary text,stamp text,icon text,link text,type text
            cv.put("nid", news.getNid());
            cv.put("title", news.getTitle());
            cv.put("summary", news.getSummary());
            cv.put("stamp", news.getStamp());
            cv.put("icon", news.getIcon());
            cv.put("link", news.getLink());
            cv.put("type", news.getType());

            db.insert(DBOpenHelper.TABLE_NAME, "link", cv);
        }
        //关闭数据库
        db.close();
    }

//    查询新闻表中有多少数据
    public boolean quaryNewsCount(){
        //打开数据库
        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select count(*) from news", null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        Log.i("dbhelper", count+"");
        cursor.close();
        db.close();
        return count == 0 ? false : true;
    }

}
