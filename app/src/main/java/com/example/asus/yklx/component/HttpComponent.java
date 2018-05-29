package com.example.asus.yklx.component;

import com.example.asus.yklx.module.HttpModule;
import com.example.asus.yklx.ui.list.Fragment1;
import com.example.asus.yklx.ui.fragment.Fragment2;

import dagger.Component;

/**
 * Created by asus on 2018/5/28.
 */
@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(Fragment1 fragment1);
    void inject(Fragment2 fragment2);
}
