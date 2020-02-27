package com.kikimore.studentbookalpha;

import android.content.Context;
import android.os.Bundle;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import com.kikimore.studentbookalpha.tabs.*;

public class pageadapter extends FragmentPagerAdapter {

    private int dayofweek;

    public pageadapter(@NonNull FragmentManager fm, AdapterView.OnItemSelectedListener contextmain){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        switch(position){
            case(0):
                 tab_monday tab_monday = new tab_monday();
                return tab_monday;
            case(1):
                tab_tuesday tab_tuesday = new tab_tuesday();
                return tab_tuesday;
            case(2):
                tab_wednesday tab_wednesday = new tab_wednesday();
                return tab_wednesday;
            case(3):
                tab_thursday tab_thursday = new tab_thursday();
                return tab_thursday;
            case(4):
                tab_friday tab_friday = new tab_friday();
                return tab_friday;
            case(5):
                tab_saturday tab_saturday = new tab_saturday();
                return tab_saturday;

                default: return null;
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

}
