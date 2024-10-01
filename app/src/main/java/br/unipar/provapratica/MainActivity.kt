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
    private lateinit var Val: EditText
    private lateinit var total: TextView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private var lis: ArrayList<ListAdapter> = ArrayList()
    private lateinit var adapter: ArrayAdapter<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        descri = findViewById(R.id.Descri)
        descriUsuario = findViewById(R.id.DescriUsuario)
        Inform = findViewById(R.id.Inform)
        InformVal = findViewById(R.id.InformVal)
        Val = findViewById(R.id.Val)
        total = findViewById(R.id.Total)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)

        btn3.setOnClickListener {
            limparCampos()
        }
    }

    private fun limparCampos() {

        descriUsuario.text.clear()
        Val.text.clear()

        total.text = "0"


    }

}
