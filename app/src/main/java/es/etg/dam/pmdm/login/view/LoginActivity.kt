package es.etg.dam.pmdm.login.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.etg.dam.pmdm.login.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
    }

    fun guardar(view: View){
        val nombre = findViewById<TextView>(R.id.txtNombre).text
        val sharedPref = getPreferences(MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("nombre", nombre.toString())
        editor.apply()
    }
}