package es.etg.dam.pmdm.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText  // ¡Cambiado de TextView a EditText!
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.etg.dam.pmdm.login.R
import es.etg.dam.pmdm.login.view.LoginActivity.Constantes.NOMBRE

class LoginActivity : AppCompatActivity() {
    object Constantes {
        const val NOMBRE: String = "Nombre"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val nombre = leer()
        if (nombre != null && nombre.isNotEmpty()) {
            findViewById<EditText>(R.id.txtNombre).setText(nombre)
        }
    }

    fun guardar(view: View) {
        val nombre = findViewById<EditText>(R.id.txtNombre).text.toString()
        val sharedPref = getPreferences(MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(NOMBRE, nombre)
        editor.apply()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(NOMBRE, nombre)
        startActivity(intent)
    }

    private fun leer(): String? {
        val sharedPref = getPreferences(MODE_PRIVATE)
        val nombre = sharedPref.getString(NOMBRE, "")
        return nombre
    }
}