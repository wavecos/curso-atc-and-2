package bo.com.cognos.quakeradar.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import bo.com.cognos.quakeradar.domain.Quake;

@Dao
public interface QuakeDAO {

    @Insert
    public void insert(Quake quake);

    @Delete
    public void delete(Quake quake);

    @Query("SELECT * FROM favorites")
    public List<Quake> getFavorites();

}
