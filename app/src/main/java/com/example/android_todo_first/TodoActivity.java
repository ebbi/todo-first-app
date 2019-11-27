package com.example.android_todo_first;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TodoActivity extends AppCompatActivity {

    private String[] mTodos;
    private int mTodoIndex = 0;

    /* In case of state change, such as rotating the phone,
       store the mTodoIndex */
    private static final String TODO_INDEX = "com.example.android_todo_first.todoIndex";

    /* override to write the value of mTodoIndex into
       the Bundle with TODO_INDEX as its key */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(TODO_INDEX, mTodoIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /* check for saved state due to changes such as rotation
            and restore any saved state such as the TODO_INDEX */
        if (savedInstanceState != null){
            mTodoIndex = savedInstanceState.getInt(TODO_INDEX, 0);
        }

        /* call the super class onCreate to complete the creation
            of activity with  any state changes */
        super.onCreate(savedInstanceState);

        /*  Refactor model
            read into mTodos array from res/values/strings.xml */
        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todos);

        /* set the user interface layout for this Activity */
        setContentView(R.layout.activity_todo);

        /* initialize member TextView so we can manipulate it later */
        final TextView TodoTextView;
        TodoTextView = (TextView) findViewById(R.id.textViewTodo);

        /* display the first task from mTodo array in the TodoTextView */
        TodoTextView.setText(mTodos[mTodoIndex]);

        /* setup navigation buttons */
        /* next button to cycle through mTodos */
        Button buttonNext;
        buttonNext = (Button) findViewById(R.id.buttonNext);

        /* OnClick listener for the  Next button */
        buttonNext.setOnClickListener(
                new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mTodoIndex += 1;
                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });

        /** TODO setup previous button object and listener
        *   to cycle through mTodos */

    }
}