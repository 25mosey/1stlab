package com.example.a1stlab

import ApiService
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a1stlab.adapters.UniversitiesAdapter
import com.example.a1stlab.models.University
import com.example.a1stlab.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService
    private lateinit var recyclerView: RecyclerView
    private lateinit var universitiesAdapter: UniversitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiService = RetrofitClient.createService(ApiService::class.java)

        val editTextCountry = findViewById<EditText>(R.id.editTextCountry)
        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        recyclerView = findViewById(R.id.recyclerViewUniversities)


        recyclerView.layoutManager = LinearLayoutManager(this)
        universitiesAdapter = UniversitiesAdapter(this)


        buttonSearch.setOnClickListener {
            val country = editTextCountry.text.toString()
            if (country.isNotEmpty()) {
                val baseUrl = "http://universities.hipolabs.com/"
                RetrofitClient.setBaseUrl(baseUrl)
                val apiService = RetrofitClient.createService(ApiService::class.java)
                val call = apiService.getUniversitiesByCountry(country)
                call.enqueue(object : Callback<List<University>> {
                    override fun onResponse(call: Call<List<University>>, response: Response<List<University>>) {
                        if (response.isSuccessful) {
                            val universities = response.body()
                            universitiesAdapter.setUniversities(universities!!)
                            recyclerView.adapter = universitiesAdapter

                        } else {
                            // Обработка ошибки
                            val errorMessage = "Ошибка получения данных: ${response.code()}"
                            Log.e(TAG, errorMessage)
                            // Показ сообщения об ошибке пользователю, если нужно
                        }
                    }

                    override fun onFailure(call: Call<List<University>>, t: Throwable) {
                        // Обработка ошибки
                        val errorMessage = "Ошибка сети: ${t.message}"
                        Log.e(TAG, errorMessage)
                        // Показ сообщения об ошибке пользователю, если нужно
                    }
                })
            } else {
                // Сообщение о том, что поле страны пусто
            }
        }


    }
}
