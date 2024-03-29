package com.wd.tech.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.wd.tech.bean.MyId;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MY_ID".
*/
public class MyIdDao extends AbstractDao<MyId, Void> {

    public static final String TABLENAME = "MY_ID";

    /**
     * Properties of entity MyId.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property UserId = new Property(0, String.class, "userId", false, "USER_ID");
        public final static Property SessionId = new Property(1, String.class, "sessionId", false, "SESSION_ID");
    }


    public MyIdDao(DaoConfig config) {
        super(config);
    }
    
    public MyIdDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MY_ID\" (" + //
                "\"USER_ID\" TEXT," + // 0: userId
                "\"SESSION_ID\" TEXT);"); // 1: sessionId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MY_ID\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MyId entity) {
        stmt.clearBindings();
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(1, userId);
        }
 
        String sessionId = entity.getSessionId();
        if (sessionId != null) {
            stmt.bindString(2, sessionId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MyId entity) {
        stmt.clearBindings();
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(1, userId);
        }
 
        String sessionId = entity.getSessionId();
        if (sessionId != null) {
            stmt.bindString(2, sessionId);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public MyId readEntity(Cursor cursor, int offset) {
        MyId entity = new MyId( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // userId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // sessionId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MyId entity, int offset) {
        entity.setUserId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setSessionId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(MyId entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(MyId entity) {
        return null;
    }

    @Override
    public boolean hasKey(MyId entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
