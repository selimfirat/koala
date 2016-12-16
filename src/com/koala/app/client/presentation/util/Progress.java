package com.koala.app.client.presentation.util;

import com.koala.app.client.presentation.main.BottomBar;

/**
 * Created by mrsfy on 16-Dec-16.
 */
public class Progress {
    public static void start(String message) {
        BottomBar.startProgress(message);
    }

    public static void end() {
        BottomBar.endProgress();
    }

}
