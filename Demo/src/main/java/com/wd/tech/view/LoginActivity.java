package com.wd.tech.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.wd.tech.R;
import com.wd.tech.bean.LoginBean;
import com.wd.tech.data.BaseActivity;
import com.wd.tech.mvp.MyInterface;
import com.wd.tech.presenter.MyPresenter;
import com.wd.tech.util.RsaCoder;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements MyInterface.ViewInter.LoginInter {

    @BindView(R.id.login_phone_id)
    EditText loginPhoneId;
    @BindView(R.id.login_pwd_id)
    EditText loginPwdId;
    @BindView(R.id.eye_id)
    ImageView eyeId;
    @BindView(R.id.login_checkbox_id)
    CheckBox loginCheckboxId;
    @BindView(R.id.to_register)
    TextView toRegister;
    @BindView(R.id.login_intent_id)
    TextView loginIntentId;
    @BindView(R.id.login_weixin_id)
    ImageView loginWeixinId;
    @BindView(R.id.login_face_id)
    ImageView loginFaceId;
    MyInterface.PresenterInter presenterInter;
    private String s;
    public static int userId;
    public static String sessionId;
    private SharedPreferences ss;
    private String phone;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ss = getSharedPreferences("ss", MODE_PRIVATE);
        boolean flag = ss.getBoolean("flag", false);
        phone=ss.getString("phone","");
        pwd=ss.getString("pwd","");
        if(flag){
            loginPhoneId.setText(phone);
            loginPwdId.setText(pwd);
            loginCheckboxId.setChecked(flag);
        }

        presenterInter = new MyPresenter<>(this);
        eyeId.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        loginPwdId.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        loginPwdId.setSelection(loginPwdId.length());
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        loginPwdId.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        loginPwdId.setSelection(loginPwdId.length());
                        break;
                    case MotionEvent.ACTION_UP:
                        loginPwdId.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        loginPwdId.setSelection(loginPwdId.length());
                        break;
                }
                return true;
            }
        });
    }

    @OnClick({R.id.to_register, R.id.login_intent_id, R.id.login_weixin_id, R.id.login_face_id})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.to_register:
                showIntent(RegisterActivity.class);
                break;
            case R.id.login_intent_id:
                phone = loginPhoneId.getText().toString();
                pwd = loginPwdId.getText().toString();
                if (TextUtils.isEmpty(pwd)) {
                    showToast("密码不能为空");
                } else {
                    SharedPreferences.Editor edit = ss.edit();
                    if (loginCheckboxId.isChecked()){
                        edit.putBoolean("flag",true);
                        edit.putString("phone", phone);
                        edit.putString("pwd", pwd);
                        edit.commit();
                    }else{
                        edit.clear();
                        edit.commit();
                    }
                    try {
                        s = RsaCoder.encryptByPublicKey(pwd);
                        presenterInter.toLogin(phone, s);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.login_weixin_id:
                break;
            case R.id.login_face_id:
                break;
        }
    }

    @Override
    public void showLogin(Object object) {
        final LoginBean bean = (LoginBean) object;
        showToast(bean.getMessage());
        if (bean.getMessage().equals("登录成功")) {
//            runOnUiThread(new Runnable() {
////                @Override
////                public void run() {
////                    dao.deleteAll();
////                    MyId myId = new MyId();
////                    myId.setUserId(bean.getResult().getUserId()+"");
////                    myId.setSessionId(bean.getResult().getSessionId());
////                    dao.insert(myId);
////                }
////            });
            userId = bean.getResult().getUserId();
            sessionId = bean.getResult().getSessionId();
            showIntent(ViewActivity.class);
            finish();
        }
    }


}
