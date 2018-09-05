package lesbros.com.bibliotheke.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lesbros.com.bibliotheke.R;
import lesbros.com.bibliotheke.entity.Book;

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.BookViewHolder> {
    static class BookViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;

        private BookViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Book> mBooks; // Cached copy of words

    public BooksListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        if (mBooks != null) {
            Book current = mBooks.get(position);
            holder.mTextView.setText(current.getCode());
        } else {
            // Covers the case of data not being ready yet.
            holder.mTextView.setText("No code");
        }
    }

    public void setBooks(List<Book> books) {
        mBooks = books;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (mBooks != null)
            return mBooks.size();
        else return 0;
    }
}
