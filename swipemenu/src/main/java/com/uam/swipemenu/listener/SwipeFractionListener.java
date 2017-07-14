package com.uam.swipemenu.listener;

import com.uam.swipemenu.SwipeMenuLayout;

/**
 * Created by tubingbing on 16/5/20.
 */
public interface SwipeFractionListener {
    void beginMenuSwipeFraction(SwipeMenuLayout swipeMenuLayout, float fraction);

    void endMenuSwipeFraction(SwipeMenuLayout swipeMenuLayout, float fraction);
}
