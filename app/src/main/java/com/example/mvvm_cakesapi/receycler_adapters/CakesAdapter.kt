package com.example.mvvm_cakesapi.receycler_adapters

import android.animation.LayoutTransition
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_cakesapi.R
import com.example.mvvm_cakesapi.database.DatabaseCakes
import com.example.mvvm_cakesapi.databinding.RowCakesBinding
import javax.net.ssl.SSLSessionBindingEvent

class CakesAdapter:RecyclerView.Adapter<CakesViewHolder>() {
    private var viewModelAdapter: CakesAdapter? = null
    var results: List<DatabaseCakes> = emptyList()
        set(value) {
            field = value
            // countryFilterList = results
            // Notify any registered observers that the data set has changed. This will cause every
            // element in our RecyclerView to be invalidated.
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
        val withDataBinding: RowCakesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CakesViewHolder.LAYOUT,
            parent,
            false
        )
        return CakesViewHolder(withDataBinding)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.results = results[position]
        }
    }
}


class CakesViewHolder (val viewDataBinding: RowCakesBinding):
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object{
        @LayoutRes
        val LAYOUT = R.layout.row_cakes
    }
}

class CakeClick(val block: (DatabaseCakes)-> Unit){

    fun onClick(cakes: DatabaseCakes) = block(cakes)

}





