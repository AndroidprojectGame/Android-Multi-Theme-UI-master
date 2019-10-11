package com.pkj.wow.multitheme;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pkj.wow.multitheme.util.ThemeUtil;

import static com.pkj.wow.multitheme.util.ThemeUtil.*;


/**
 * Created by Pankaj on 03-11-2017.
 */

public class BaseActivity1 extends AppCompatActivity {
    public static int mTheme = THEME_RED;
    public static boolean mIsNightMode = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("Theme", MODE_PRIVATE);
        mTheme = prefs.getInt("id", 0);
        setTheme(ThemeUtil.getThemeId(mTheme));
    }
}
