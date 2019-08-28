package me.gitai.hosts;

import android.app.Application;

import java.util.List;

import me.gitai.hosts.entities.Host;
import me.gitai.hosts.utils.HostsManager;
import me.gitai.library.util.L;
import me.gitai.library.util.SharedPreferencesUtil;
import me.gitai.library.util.ToastUtil;

/**
 * Created by dphdjy on 15-11-5.
 */
public class HostsApp extends Application {
    private static HostsManager whilelist;

    public static List<Host> getWhilelist() {
        return whilelist.getHosts(true);
    }

    public static void setWhilelist(HostsManager hm) {
        whilelist = hm;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        L.setLogcatEnable(this, true);
        L.setLogToFileEnable(true, this, Constant.LOGS_FOLDER_NAME);

        ToastUtil.initialize(this);
        SharedPreferencesUtil.initialize(this);

        L.d();

        whilelist = new HostsManager(this, "whilelist");
    }
}
