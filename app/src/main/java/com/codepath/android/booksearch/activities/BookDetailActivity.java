package com.codepath.android.booksearch.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codepath.android.booksearch.GlideApp;
import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.models.Book;

import org.parceler.Parcels;

import java.util.Objects;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        // Fetch views
        ImageView ivBookCover = (ImageView) findViewById(R.id.ivBookCover);
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        TextView tvAuthor = (TextView) findViewById(R.id.tvAuthor);

        // Extract book object from intent extras
        Book book = Parcels.unwrap(getIntent().getParcelableExtra(Book.class.getSimpleName()));
        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        GlideApp.with(this)
                .load(book.getCoverUrl())
                .into(ivBookCover);

        Objects.requireNonNull(getSupportActionBar()).setTitle(book.getTitle());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
