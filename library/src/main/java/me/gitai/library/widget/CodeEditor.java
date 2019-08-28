package me.gitai.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class CodeEditor extends EditText {
    public CodeEditor(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context) {

    }

    public String getCode() {
        return getText().toString();
    }
}
