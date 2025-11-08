package es.etg.dam.pmdm.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.etg.dam.pmdm.login.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        val nombreTextView = findViewById<TextView>(R.id.txtNombre)
        val extras = intent.extras

        if (extras != null) {
            val nombre = extras.getString(LoginActivity.Constantes.NOMBRE, "")
            nombreTextView.text = nombre
        }
    }

    fun volver(view : View){
        val intent = Intent(this, LoginActivity::class.java);
        startActivity(intent);
    }
}