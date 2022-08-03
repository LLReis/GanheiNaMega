package co.llreis.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import co.llreis.ganheinamega.R
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Aqui onde começa...
        setContentView(R.layout.activity_main)

        //Buscar os objetos e referências
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        btnGenerate.setOnClickListener {

            val text = editText.text.toString()

            numberGenerator(text, txtResult)
        }

    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        //validar quando o campo é vazio
        if (text.isEmpty()) {
            Toast.makeText(this, "Inform um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        val qtd = text.toInt() // convertendo string pra inteiro

        if (qtd < 6 || qtd > 15) {
            //condição de falha
            //validar se o campo informado é entre 6 e 15
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

            val numbers = mutableSetOf<Int>()
            val random = Random()

            while (true) {
                val number = random.nextInt(60)
                numbers.add(number + 1)

                if (numbers.size == qtd) {
                    break
                }
            }

            txtResult.text = numbers.joinToString(" - ")



    }
}