package lesbros.com.bibliotheke.books.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lesbros.com.bibliotheke.R;

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.ViewHolder> {
    private List<String> booksList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public BooksListAdapter(List<String> booksList) {
        this.booksList = booksList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bookslist_row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(booksList.get(position));
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }
}
