package com.tienanh.anhntph37315_assignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tienanh.anhntph37315_assignment.database.dao.CartDao
import com.tienanh.anhntph37315_assignment.database.dao.ProductDao
import com.tienanh.anhntph37315_assignment.database.dao.SaveUserDao
import com.tienanh.anhntph37315_assignment.database.dao.UserDao
import com.tienanh.anhntph37315_assignment.database.entities.Carts
import com.tienanh.anhntph37315_assignment.database.entities.Products
import com.tienanh.anhntph37315_assignment.database.entities.SaveUsers
import com.tienanh.anhntph37315_assignment.database.entities.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [Users::class, Products::class, Carts::class, SaveUsers::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
    abstract fun cartDao(): CartDao
    abstract fun saveUserDao(): SaveUserDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null
        fun getDatabase(context: Context, scope: CoroutineScope): MyDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    "item_database"
                ).addCallback(ProductDatabaseCallback(scope))
                    .build()
                    .also { INSTANCE = it }
            }
        }

        class ProductDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(productDao = database.productDao())
                    }
                }
            }

            suspend fun populateDatabase(productDao: ProductDao) {
                val products1 = Products(
                    id = 1,
                    "san pham 1",
                    "https://deviet.vn/wp-content/uploads/2019/04/vuong-quoc-anh.jpg",
                    5,
                    2
                )
                val products2 = Products(
                    id = 2,
                    "san pham 2",
                    "https://png.pngtree.com/thumb_back/fw800/background/20240205/pngtree-interior-of-living-room-with-floor-lamp-photo-image_3082925.jpg",
                    6,
                    5
                )
                val products3 = Products(
                    id = 3,
                    "san pham 3",
                    "https://png.pngtree.com/thumb_back/fw800/background/20240205/pngtree-interior-of-living-room-with-floor-lamp-photo-image_3082925.jpg",
                    6,
                    4
                )
                val products4 = Products(
                    id = 4,
                    "san pham 4",
                    "https://png.pngtree.com/thumb_back/fw800/background/20240205/pngtree-interior-of-living-room-with-floor-lamp-photo-image_3082925.jpg",

                    5,
                    1
                )
                val products5 = Products(
                    id = 5,
                    "san pham 5",
                    "https://png.pngtree.com/thumb_back/fw800/background/20240205/pngtree-interior-of-living-room-with-floor-lamp-photo-image_3082925.jpg",
                    5,
                    2
                )
                val products6 = Products(
                    id = 6,
                    "san pham 6",
                    "https://png.pngtree.com/thumb_back/fw800/background/20240205/pngtree-interior-of-living-room-with-floor-lamp-photo-image_3082925.jpg",
                    8,
                    3
                )
                productDao.addProduct(products1)
                productDao.addProduct(products2)
                productDao.addProduct(products3)
                productDao.addProduct(products4)
                productDao.addProduct(products5)
                productDao.addProduct(products6)
            }
        }
    }
}