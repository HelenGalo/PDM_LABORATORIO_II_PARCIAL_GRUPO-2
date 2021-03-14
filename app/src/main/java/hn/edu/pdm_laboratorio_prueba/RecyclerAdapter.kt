package hn.edu.pdm_laboratorio_prueba
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val titles = arrayOf(
        "Registrar Alumno",
        "Matricula", "Registrar Clase", "Ingresar Notas",
        "Enviar Matricula", "Enviar Nota"
    )

    private val details = arrayOf(
        "Item detalle 1", "Item detalle 2",
        "Item detalle 3", "Item detalle 4",
        "Item detalle 5", "Item detalle 6",
        "Item detalle 7", "Item detalle 8"
    )

    private val images = intArrayOf(
        R.drawable.image2,
        R.drawable.imagen1, R.drawable.clases,
        R.drawable.images3, R.drawable.images4,
        R.drawable.image5
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView


        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener { v: View? ->
                var position: Int = getAdapterPosition()
                if (v == null) {
                    if (v != v) {
                        Snackbar.make(
                            v, "Click  en el item $position",
                            Snackbar.LENGTH_LONG
                        ).setAction("Action", null).show()
                    }
                } else {

                    val context1: Context = itemView.getContext()
                    val intent = Intent(context1, RealizarMatricula::class.java)
                    context1.startActivity(intent)


                }


            }


        }
    }





    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.itemTitle.text= titles[i]
        holder.itemDetail.text= details[i]
        holder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}