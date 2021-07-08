package br.com.testes_automatizados_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.testes_automatizados_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val nomes = mutableListOf<String>()
    private lateinit var itemAdapter:ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMainAdapter()
        binding.run {
            with(buttonLimpar){
                setOnClickListener {
                    clearList()
                }
            }
            with(buttonNome){
                setOnClickListener {
                    val nome = editTextNome.text.toString()
                    if (nome.isNotEmpty()) addNome(nome) else textViewCampoObrigatorio.text = getString(R.string.campo_obrigatorio)
                }

            }
        }

    }
    private fun setMainAdapter(){
        itemAdapter = ItemAdapter(nomes)
        with(binding.recyclerView){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = itemAdapter
        }
    }
    private fun addNome(nome:String){
        with(binding){
            editTextNome.setText("")
            itemAdapter.addNome(nome)
        }
    }
    private fun clearList(){
        itemAdapter.clearNomes()
    }
}