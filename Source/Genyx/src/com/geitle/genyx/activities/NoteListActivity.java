package com.geitle.genyx.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.geitle.genyx.R;

public class NoteListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_list);
		
//        mCursor = this.getContentResolver().query(People.CONTENT_URI, null, null, null, null);
//        startManagingCursor(mCursor);
//
//        // Now create a new list adapter bound to the cursor.
//        // SimpleListAdapter is designed for binding to a Cursor.
//
//        // Bind to our new adapter.
//        setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.note_list, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_new_note:
	        	openNewNote();
	            return true;
	        case R.id.action_view_note_map:
	        	openNoteMapList();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	private void openNewNote() {
		Intent intent = new Intent(this, EditNoteActivity.class);
		this.startActivity(intent);
	}
	
	private void openNoteMapList() {
		Intent intent = new Intent(this, NoteMapActivity.class);
		this.startActivity(intent);
	}
}
