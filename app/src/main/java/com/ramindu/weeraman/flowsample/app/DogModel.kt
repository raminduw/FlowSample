package com.ramindu.weeraman.flowsample.app

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.ramindu.weeraman.flowsample.R


@ModelView(
    saveViewState = true,
    autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT
)
class DogModel @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
) : RelativeLayout(context, attr, defStyle) {
    private val name: TextView

    //private lateinit var model: DogUIModel
    init {
        val root = LayoutInflater
            .from(context)
            .inflate(R.layout.item, this, false)
        addView(root)
        name = findViewById(R.id.dogName)

    }

    @TextProp
    fun setName(text: CharSequence?) {
        name.setText(text)
    }
}

data class DogUIModel(val name: String)