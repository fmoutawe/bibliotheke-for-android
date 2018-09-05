package lesbros.com.bibliotheke;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import lesbros.com.bibliotheke.adapter.BooksListAdapter;
import lesbros.com.bibliotheke.entity.Book;
import lesbros.com.bibliotheke.viewmodel.BookViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    public HomeActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.booksList);
        mRecyclerView.setHasFixedSize(true);

        final BooksListAdapter adapter = new BooksListAdapter(getActivity());

        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        BookViewModel mBookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);

        mBookViewModel.getAllBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable final List<Book> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setBooks(words);
            }
        });

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
//
//        List<String> booksList = new ArrayList<>();
//        for (int i = 0; i < 3000; i++) {
//            booksList.add(i + ": Arbitre");
//            booksList.add(i + ": Breton");
//            booksList.add(i + ": Carousel");
//            booksList.add(i + ": Detroit");
//            booksList.add(i + ": Envie");
//            booksList.add(i + ": Feu");
//            booksList.add(i + ": Grotte");
//            booksList.add(i + ": Humour");
//            booksList.add(i + ": Invisible");
//            booksList.add(i + ": Jamais");
//            booksList.add(i + ": Koala");
//            booksList.add(i + ": Loutre");
//            booksList.add(i + ": Maman");
//        }
//
//        mAdapter = new BooksListAdapter(booksList);
//        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
