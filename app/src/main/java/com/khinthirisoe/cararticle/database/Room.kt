package com.khinthirisoe.cararticle.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArticleDao {
    @Query("select * from databasearticle")
    fun getArticles(): LiveData<List<DatabaseArticle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg article: DatabaseArticle)
}

@Database(entities = [DatabaseArticle::class], version = 1)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract val articleDao: ArticleDao
}

private lateinit var INSTANCE: ArticlesDatabase

fun getDatabase(context: Context): ArticlesDatabase {

    synchronized(ArticlesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                ArticlesDatabase::class.java,
                "articles"
            ).build()
        }
    }
    return INSTANCE
}