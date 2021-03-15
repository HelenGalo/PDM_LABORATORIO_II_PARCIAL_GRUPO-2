package hn.edu.pdm_laboratorio_prueba
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var paciente:String="HEY"

    fun enviarDatos(paciente: String) {
        this.paciente = paciente
        println("ESTO ES "+this.paciente)

    }

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
        var buttonPrueba: Button


        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
            buttonPrueba = itemView.findViewById(R.id.buttonPrueba)




            itemView.setOnClickListener { v: View? ->
                var position:Int = getAdapterPosition()
                println(position.toString())


                when(position){
                    0 -> GoRegistrarAlumno(itemView)
                    1 -> GoMatricula(itemView)
                    2 -> GoRegistrarClase(itemView)
                    3 -> GoIngresarNotas(itemView)
                    4 -> GoEnviarMatricula(itemView)
                    5 -> GoEnviarNota(itemView)
                    else-> GoMain(itemView)

                }





            }


        }


    }

    private fun GoMain(itemView: View){
        val intent = Intent(itemView.context, MainActivity::class.java)
        itemView.context.startActivity(intent)

    }

    private fun GoEnviarNota(itemView: View) {
        val intent = Intent(itemView.context, EnviarNotas::class.java)
        itemView.context.startActivity(intent)

    }

    fun GoRegistrarAlumno(itemView: View){
        val intent = Intent(itemView.context, RegistrarAlumno::class.java)
        itemView.context.startActivity(intent)

    }

    fun GoMatricula(itemView: View){
        val intent = Intent(itemView.context, RealizarMatricula::class.java)
        intent.putExtra("studio", paciente)
        itemView.context.startActivity(intent)

    }

    fun GoEnviarMatricula(itemView: View){
        val intent = Intent(itemView.context, EnviarMatricula::class.java)
        intent.putExtra("Variable", "")
        itemView.context.startActivity(intent)


    }

    fun GoIngresarNotas(itemView: View){
        val intent = Intent(itemView.context, IngresarNotas::class.java)
        itemView.context.startActivity(intent)

    }

    fun GoRegistrarClase(itemView: View){
        val intent = Intent(itemView.context, RegistrarClase::class.java)
        itemView.context.startActivity(intent)

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