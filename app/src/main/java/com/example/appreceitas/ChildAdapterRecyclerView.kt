package com.example.appreceitas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_card.view.*

class ChildAdapterRecyclerView(private val recipes: List<Model>,
                               private val context: Context?,
                               private val onClick: (Model) -> Unit) : RecyclerView.Adapter<ChildAdapterRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bindView(recipe, onClick)

    }

    override fun getItemCount(): Int {
        return recipes.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.recipeTitle
        val ingredients = itemView.recipeIngredients
        val preparationMode = itemView.recipePrepMode

        fun bindView(recipe: Model, onClick: (Model) -> Unit) {

            title.text = recipe.title
            ingredients.text = recipe.ingredients
            preparationMode.text = recipe.prepMode

            itemView.setOnClickListener {
                onClick(recipe)
            }

        }
    }
}