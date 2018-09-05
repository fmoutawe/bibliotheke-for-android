package lesbros.com.bibliotheke.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import lesbros.com.bibliotheke.dao.BookDao;
import lesbros.com.bibliotheke.entity.Book;
import lesbros.com.bibliotheke.room.BookRoomDatabase;

public class BookRepository {

    private BookDao mBookDao;
    private LiveData<List<Book>> mAllBooks;

    public BookRepository(Application application) {
        BookRoomDatabase db = BookRoomDatabase.getDatabase(application);
        mBookDao = db.bookDao();
        mAllBooks = mBookDao.getAllBooks();
    }

    public LiveData<List<Book>> getAllBooks() {
        return mAllBooks;
    }

    public void insert(Book book) {
        new insertAsyncTask(mBookDao).execute(book);
    }

    private static class insertAsyncTask extends AsyncTask<Book, Void, Void> {

        private BookDao mAsyncTaskDao;

        insertAsyncTask(BookDao bookDao) {
            mAsyncTaskDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            mAsyncTaskDao.insert(books[0]);
            return null;
        }
    }
}
