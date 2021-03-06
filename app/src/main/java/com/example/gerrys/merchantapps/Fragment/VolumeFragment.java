package com.example.gerrys.merchantapps.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerrys.merchantapps.R;

/**
 * Created by Admin on 3/15/2017.
 */

public class VolumeFragment extends Fragment {

    private static ViewPager mPager;
    private TabLayout mTabLayout;
    private String ID;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_volume, container, false);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        mPager.setAdapter(new TabsAdapter(getChildFragmentManager()));


        mTabLayout.setupWithViewPager(mPager);
        Bundle bundle = this.getArguments();
        ID = bundle.getString("MerchantId");

       // Log.d("IDDDDDDDDDDDDDDDDDD", ID);
        //fragment.setID(ID);
        setHasOptionsMenu(true);

        return view;
    }

    class TabsAdapter extends FragmentPagerAdapter {

        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    ReimburseSaldo geo = new ReimburseSaldo();
                    Bundle bun =  new Bundle();
                    bun.putString("MerchantId",ID);
                    geo.setArguments(bun);
                    return geo;
                case 1:
                    return new ReimburseSaldo();
                case 2:
                    return new TabGeoCone();
                case 3:
                    return new TabGeoCone();

            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "My Product";
                case 1:
                    return "Reimburse Saldo";
                case 2:
                    return "Reimburese History";
                case 3:
                    return "Order History";

            }
            return "";
        }
    }
}
