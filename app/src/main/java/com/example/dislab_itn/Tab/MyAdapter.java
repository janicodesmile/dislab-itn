package com.example.dislab_itn.Tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.dislab_itn.Fragment.AboutFragment;
import com.example.dislab_itn.Fragment.HomeFragment;
import com.example.dislab_itn.Fragment.NilaiFragment;
import com.example.dislab_itn.R;

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles ={"A","B","C"};
    int[] icon = new int[]{R.drawable.ic_keyboard_black_24dp,R.drawable.ic_keyboard_black_24dp,R.drawable.ic_keyboard_black_24dp};
    private int heightIcon;

    public MyAdapter(androidx.fragment.app.FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        Fragment frag = null;

        if(position ==0){
            frag = new HomeFragment();
        }else if(position == 1){
            frag = new NilaiFragment();
        }else if(position == 2){
            frag = new AboutFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}
