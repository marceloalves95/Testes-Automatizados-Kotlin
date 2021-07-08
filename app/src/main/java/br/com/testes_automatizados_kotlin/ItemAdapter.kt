package br.com.testes_automatizados_kotlin

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import br.com.testes_automatizados_kotlin.databinding.ItemAdapterBinding

/**
 * @author RubioAlves
 * Created 30/06/2021 at 10:30
 */
class ItemAdapter(private val nomes: MutableList<String>) : RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder>() {

    inner class ItemAdapterViewHolder(private val itemBinding: ItemAdapterBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(nome: String) {
            itemBinding.textViewItem.text = nome
        }

    }

    override fun onCreateViewHolder(
        parent: android.view.ViewGroup,
        viewType: Int
    ): ItemAdapterViewHolder {

        val itemBinding =
            ItemAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemAdapterViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: ItemAdapterViewHolder, position: Int) {

        holder.bind(nomes[position])
    }

    override fun getItemCount(): Int = nomes.size

    fun addNome(nome:String){
        nomes.add(nome)
        notifyItemInserted(nomes.size-1)
    }
    fun clearNomes(){
        val itemCount = nomes.size-1
        nomes.clear()
        notifyItemRangeRemoved(0, itemCount)
    }

}