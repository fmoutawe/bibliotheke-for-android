package lesbros.com.bibliotheke.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import lesbros.com.bibliotheke.entity.Book;

@Dao
public interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Book book);

    @Query("DELETE FROM book")
    void deleteAll();

    @Query("SELECT * from book ORDER BY code asc")
    LiveData<List<Book>> getAllBooks();
}
