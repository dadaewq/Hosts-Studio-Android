package me.gitai.library;

import com.orm.SugarApp;

import me.gitai.library.util.L;
import me.gitai.library.util.SharedPreferencesUtil;
import me.gitai.library.util.ToastUtil;

public class BaseApplication extends SugarApp implements Thread.UncaughtExceptionHandler {
    protected static BaseApplication _this = null;

    public static BaseApplication getApplication() {
        return _this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _this = this;

        L.setLogcatEnable(this, true);
        L.setLogToFileEnable(true, this);

        ToastUtil.initialize(this);
        SharedPreferencesUtil.initialize(this);

        L.d();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        L.e(ex);
        System.exit(1);
    }
}
