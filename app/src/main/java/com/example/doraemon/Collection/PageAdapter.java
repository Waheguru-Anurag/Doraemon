package com.example.doraemon.Collection;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int couttab;

    public PageAdapter(FragmentManager fm, int couttab) {
        super(fm);
        this.couttab = couttab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                    return new Main2Activity();
            case 1:
                    return new Main3Activity();
            case 2:
                    return new Main6Activity();
            default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return couttab;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
