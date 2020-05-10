package com.kelompok.worklist.customfont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;



public class CheckedTextView extends android.support.v7.widget.AppCompatCheckedTextView {
    public CheckedTextView(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CheckedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/avenir.ttf", context);
        setTypeface(customFont);
    }
}
