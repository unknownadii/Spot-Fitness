package com.example.spotfitness.Fragments

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.spotfitness.Adapter.NutritionAdapter
import com.example.spotfitness.Data.NutritionData
import com.example.spotfitness.R
import com.example.spotfitness.Singleton.HomeSingleton
import kotlinx.android.synthetic.main.fragment_nutrition.*

class NutritionFragment:Fragment(R.layout.fragment_nutrition) {
    private var api ="kivCLNK8mcjacOd1SDmlXwkFRGz1mSBw2wMyG0jC"
    private var domainSource ="https://api.nal.usda.gov/fdc/v1/foods/search?"
    lateinit var nutritionList :ArrayList<NutritionData>
    lateinit var adapter: NutritionAdapter
    lateinit var dialog: Dialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_Nutrition.layoutManager = GridLayoutManager(requireContext(), 2)
        // This loop will create 20 Views containing
        // the image with the count of view
        adapter = NutritionAdapter()

        searchIconNutrition.setOnClickListener {
            if (et_nutrition.text?.isEmpty() == true) {
                Toast.makeText(context, "Enter Something To Search", Toast.LENGTH_SHORT).show()
            } else {
                tv_Nutrition.visibility=View.GONE
                   showDialog()
               tv_DishName.text= et_nutrition.text.toString()
                getApi(et_nutrition.text.toString())
                cv_nutrition.visibility=View.VISIBLE
            }

        }

        rv_Nutrition.adapter = adapter

    }
    private fun getApi(foodName : String) {
        val url = "${domainSource}query=$foodName&pageSize=2&api_key=$api"
        // Request a string response from the provided URL.
        val getSearchRequest: JsonObjectRequest = object : JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener {
                try {
                       hideDialog()
                    val foodsJsonArray = it.getJSONArray("foods")
                     nutritionList = ArrayList<NutritionData>()
                    val atIndexZero = foodsJsonArray.getJSONObject(0)
                    val foodNutrientsJsonArray = atIndexZero.getJSONArray("foodNutrients")
                    for (i in 0 until foodNutrientsJsonArray.length()) {
                        val nutritionJsonObject = foodNutrientsJsonArray.getJSONObject(i)
                        val nutritionName = nutritionJsonObject.getString("nutrientName")
                        val nutritionQuantity = nutritionJsonObject.getString("value").toString()
                        val nutritionUnit = nutritionJsonObject.getString("unitName")
                        val quantity = nutritionQuantity + nutritionUnit
                        nutritionList.add(NutritionData(nutritionName, quantity))
                    }

                    adapter.update(nutritionList)

                } catch (e: Exception) {
                    hideDialog()
                    Toast.makeText(requireContext(), "Not Avilable", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener {
                hideDialog()
                Toast.makeText(requireContext(), "error occured", Toast.LENGTH_SHORT).show()
            }
        )
//for dealing with exception E/Volley: [4436] NetworkUtility.shouldRetryException: Unexpected response code 403
        {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["User-Agent"] = "Mozilla/5.0"
                return params
            }
        }
        // Add a request (in this example, called stringRequest) to your RequestQueue.
       HomeSingleton.getInstance(requireContext()).addToRequestQueue(getSearchRequest)

    }
    private fun showDialog() {
        dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_wait)
        dialog.setCancelable(false)
        dialog.show()
    }

    private fun hideDialog() {
        dialog.dismiss()
    }
}