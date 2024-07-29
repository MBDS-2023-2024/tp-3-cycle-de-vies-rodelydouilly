package fr.gobelins.dmi1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnHomeCompute: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialiser le bouton
        btnHomeCompute = findViewById(R.id.btn_home_compute)

        // Définir le listener de clic
        btnHomeCompute.setOnClickListener {
            btnHomeCompute.setOnClickListener {
                val intent = Intent(this, ComputeActivity::class.java)
                intent.extras?.putString("operation", "ADD")
                startActivity(intent)
            }
        }
    }
}
