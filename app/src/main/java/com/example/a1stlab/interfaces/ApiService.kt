import com.example.a1stlab.models.University
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun getUniversitiesByCountry(@Query("country") country: String): Call<List<University>>
}