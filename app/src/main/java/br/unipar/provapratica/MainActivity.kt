package br.unipar.provapratica

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var descri: TextView
    private lateinit var descriUsuario: EditText
    private lateinit var Inform: TextView
    private lateinit var InformVal: TextView
    private lateinit var valEditText: EditText
    private lateinit var total: TextView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var listView: ListView

    private var lis: ArrayList<String> = ArrayList()
    private lateinit var adapter: ArrayAdapter<String>
    private var isCredit = true 
    private var totalValue = 0.0 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        descri = findViewById(R.id.Descri)
        descriUsuario = findViewById(R.id.DescriUsuario)
        Inform = findViewById(R.id.Inform)
        InformVal = findViewById(R.id.InformVal)
        valEditText = findViewById(R.id.Val)
        total = findViewById(R.id.Total)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        listView = findViewById(R.id.listView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lis)
        listView.adapter = adapter

        btn1.setOnClickListener {
            isCredit = true
        }

        btn2.setOnClickListener {
            isCredit = false
        }

        btn4.setOnClickListener {
            adicionarTransacao()
        }

        btn3.setOnClickListener {
            limparCampos()
        }
    }

    private fun adicionarTransacao() {
        val descricao = descriUsuario.text.toString()
        val valorText = valEditText.text.toString()

        if (descricao.isNotEmpty() && valorText.isNotEmpty()) {
            val valor = valorText.toDouble()

            if (isCredit) {
                totalValue += valor
                lis.add("Crédito: $descricao - R$ $valor")
            } else {
                totalValue -= valor
                lis.add("Débito: $descricao - R$ $valor")
            }

            adapter.notifyDataSetChanged()

            total.text = "Total: R$ %.2f".format(totalValue)

            limparCampos()
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun limparCampos() {
        descriUsuario.text.clear()
        valEditText.text.clear()
    }
}
