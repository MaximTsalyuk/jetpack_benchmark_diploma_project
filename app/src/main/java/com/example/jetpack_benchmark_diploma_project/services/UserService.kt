import com.example.jetpack_benchmark_diploma_project.models.UserModel
import com.example.jetpack_benchmark_diploma_project.models.UsersRepsonse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://randomuser.me/"

interface UserService {
    @GET("api")
    suspend fun getUsers(@Query("results") userAmount: Int): UsersRepsonse

    companion object {
        private var userService: UserService? = null
        fun getInstance(): UserService {
            if (userService == null) {
                userService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(UserService::class.java)
            }
            return userService!!
        }
    }
}