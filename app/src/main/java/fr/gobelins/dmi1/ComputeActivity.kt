package fr.gobelins.dmi1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity() {
    lateinit var operand1: EditText
    lateinit var operand2: EditText
    lateinit var affichage: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)

        // Initialiser les EditText et TextView
        operand1 = findViewById(R.id.first_operand)
        operand2 = findViewById(R.id.second_operand)
        affichage = findViewById(R.id.Affiche)

        // Récupérer les valeurs des EditText
        val nlleOperande1 = operand1.text.toString().toDoubleOrNull() ?: return run {
            Toast.makeText(this, "Veuillez entrer une donnée valide", Toast.LENGTH_SHORT).show()
        }
        val nlleOperande2 = operand2.text.toString().toDoubleOrNull() ?: return run {
            Toast.makeText(this, "Veuillez entrer une donnée valide", Toast.LENGTH_SHORT).show()
        }

        // Récupérer l'opération depuis l'intent
        val operation = intent.getStringExtra("operation") ?: "ADD"

        // Effectuer l'opération selon le type
        val result = when (operation) {
            "ADD" -> nlleOperande1 + nlleOperande2
            "SUBTRACT" -> nlleOperande1 - nlleOperande2
            "MULTIPLY" -> nlleOperande1 * nlleOperande2
            "DIVIDE" -> if (nlleOperande2 != 0.0) nlleOperande1 / nlleOperande2 else return run {
                Toast.makeText(this, "Division par zéro impossible", Toast.LENGTH_SHORT).show()
            }
            else -> return run {
                Toast.makeText(this, "Opération inconnue", Toast.LENGTH_SHORT).show()
            }
        }

        // Afficher le résultat
        affichage.text = result.toString()
    }
}
