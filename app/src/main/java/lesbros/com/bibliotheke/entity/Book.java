package lesbros.com.bibliotheke.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "book")
public class Book {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "code")
    private String code;

    public Book(@NonNull String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
