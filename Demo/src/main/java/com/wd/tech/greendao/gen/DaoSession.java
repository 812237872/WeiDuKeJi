package com.wd.tech.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.wd.tech.bean.MyId;

import com.wd.tech.greendao.gen.MyIdDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig myIdDaoConfig;

    private final MyIdDao myIdDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        myIdDaoConfig = daoConfigMap.get(MyIdDao.class).clone();
        myIdDaoConfig.initIdentityScope(type);

        myIdDao = new MyIdDao(myIdDaoConfig, this);

        registerDao(MyId.class, myIdDao);
    }
    
    public void clear() {
        myIdDaoConfig.clearIdentityScope();
    }

    public MyIdDao getMyIdDao() {
        return myIdDao;
    }

}