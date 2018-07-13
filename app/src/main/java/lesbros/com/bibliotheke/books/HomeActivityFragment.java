package lesbros.com.bibliotheke.books;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lesbros.com.bibliotheke.R;
import lesbros.com.bibliotheke.books.adapter.BooksListAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.booksList);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        List<String> booksList = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            booksList.add(i + ": Arbitre");
            booksList.add(i + ": Breton");
            booksList.add(i + ": Carousel");
            booksList.add(i + ": Detroit");
            booksList.add(i + ": Envie");
            booksList.add(i + ": Feu");
            booksList.add(i + ": Grotte");
            booksList.add(i + ": Humour");
            booksList.add(i + ": Invisible");
            booksList.add(i + ": Jamais");
            booksList.add(i + ": Koala");
            booksList.add(i + ": Loutre");
            booksList.add(i + ": Maman");
        }

        mAdapter = new BooksListAdapter(booksList);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
