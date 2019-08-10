package com.yvesm.plainolnotes;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NotesCursorAdapter extends CursorAdapter {
    public NotesCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Retrieve the value from the cursor
        String noteText = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT));

        // Check for line feed and replace with ellipses if found
        int pos = noteText.indexOf(10); // ASCII value for line feed
        if (pos != -1) {
            noteText = noteText.substring(0, pos) + "...";
        }

        // Set the TextView
        TextView tvNote = (TextView) view.findViewById(R.id.tvNote);
        tvNote.setText(noteText);
    }
}
