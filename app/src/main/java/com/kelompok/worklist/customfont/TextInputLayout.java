package com.kelompok.worklist.customfont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;



public class TextInputLayout extends android.support.design.widget.TextInputLayout {
    public TextInputLayout(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public TextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public TextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/avenir.ttf", context);
        setTypeface(customFont);
    }
}
