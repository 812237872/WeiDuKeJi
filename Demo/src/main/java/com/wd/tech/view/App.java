package com.wd.tech.view;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.tech.greendao.gen.DaoMaster;
import com.wd.tech.greendao.gen.DaoSession;

/**
 * @Author: zhang
 * @Date: 2019/6/9 13:04
 * @Description:
 */
public class App extends Application {

    public static DaoSession userDao;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        DaoMaster.DevOpenHelper user = new DaoMaster.DevOpenHelper(this, "user");
        SQLiteDatabase userWritableDatabase = user.getWritableDatabase();
        userDao = new DaoMaster(userWritableDatabase).newSession();
    }
}
