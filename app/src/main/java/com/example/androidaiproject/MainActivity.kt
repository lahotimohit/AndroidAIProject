package com.example.androidaiproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidaiproject.databinding.ActivityMainBinding
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scbtn.setOnClickListener {
            var uquestion = binding.userinput.text.toString()
            var apiInterface = RetrofitClient.getResponse().create(AI_Interface::class.java)
            var call:Call<JsonObject> = apiInterface.getResult(uquestion)
            call.enqueue(object:Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                    var jobject = JSONObject(response?.body().toString())
                    var answer = jobject.optString("msg", "Solution Not Found...")
                    binding.outputtxt.text = answer
                }

                override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                    Log.e("Error", ""+t, )
                    binding.outputtxt.text = "Unknown Exception Occurred..."
                }

            })
        }
    }
}