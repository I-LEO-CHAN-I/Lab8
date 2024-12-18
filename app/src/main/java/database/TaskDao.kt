package database
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.leonchik.android.lab8.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getTask(): MutableList<Task>
    @Insert
    fun addTask(task: Task)
    @Delete
    fun delTask(task: Task)
}