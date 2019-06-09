package com.wd.tech.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wd.tech.R;
import com.wd.tech.bean.PostBean;
import com.wd.tech.data.BaseActivity;
import com.wd.tech.mvp.MyInterface;
import com.wd.tech.presenter.MyPresenter;
import com.wd.tech.util.RsaCoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements MyInterface.ViewInter.RegisterInter {

    @BindView(R.id.register_name_id)
    EditText registerNameId;
    @BindView(R.id.register_phone_id)
    EditText registerPhoneId;
    @BindView(R.id.register_pwd_id)
    EditText registerPwdId;
    @BindView(R.id.to_sms_id)
    TextView toSmsId;
    @BindView(R.id.register_intent_id)
    TextView registerIntentId;
    MyInterface.PresenterInter presenterInter;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenterInter = new MyPresenter<>(this);
    }

    @OnClick({R.id.to_sms_id, R.id.register_intent_id})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.to_sms_id:
                break;
            case R.id.register_intent_id:
                String name = registerNameId.getText().toString();
                String phone = registerPhoneId.getText().toString();
                String pwd = registerPwdId.getText().toString();
                if (TextUtils.isEmpty(pwd)){
                    showToast("密码不能为空");
                }else {
                    try {
                        s = RsaCoder.encryptByPublicKey(pwd);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    presenterInter.toRegister(name,phone,s);
                }
                break;
        }
    }

    @Override
    public void showRegister(Object object) {
        PostBean bean = (PostBean) object;
        showToast(bean.getMessage());
        if (bean.getMessage().equals("注册成功")){
            finish();
        }
    }
}
