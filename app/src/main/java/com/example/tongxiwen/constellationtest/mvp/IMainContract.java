package com.example.tongxiwen.constellationtest.mvp;

import android.util.SparseArray;

import java.util.List;

public interface IMainContract {
    interface View{
        void showFragments(List<SparseArray> fragments);
        void showImages(List<Integer> imgSrc);
        void setPresenter(Presenter presenter);
    }
    interface Presenter{
        void requestImage();
        void requestFragments(String type);
        void bindView(View view);
    }
    interface Model{

    }
}
