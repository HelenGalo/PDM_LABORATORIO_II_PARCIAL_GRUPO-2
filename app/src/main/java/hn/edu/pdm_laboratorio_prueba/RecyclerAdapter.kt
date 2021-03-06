package hn.edu.pdm_laboratorio_prueba
import android.content.Intent
import android.os.Process
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var  data: HashMap<Int, String> = hashMapOf()
    var  data_clase: HashMap<Int, String> = hashMapOf()
    var  mF: HashMap<Int, String> = hashMapOf()
    var cantidad:Int=0
    var nota:HashMap<Int, String> = hashMapOf()

    fun enviarDatos1(dat: HashMap<Int, String>, g:HashMap<Int,String>) {
        this.mF = dat
        this.nota = g
        println("ESTO ES "+this.mF.toString()+ this.nota.toString())

    }

    fun enviarDatos(dat: HashMap<Int, String>) {
        this.data = dat

        println("ESTO ES "+this.data.toString())

    }


    fun enviarClases(dat: HashMap<Int, String>, clas:HashMap<Int,String> ,h:Int) {
        this.data=dat
        this.data_clase = clas
        this.cantidad=h
        println("ESTO ES "+this.data_clase.toString())
        println("ESTO ES "+this.data.toString())


    }
    fun enviarm(c:HashMap<Int,String>){


        this.mF=c
        println("ESTO ES "+this.mF.toString())

    }


    fun enviar_clases_notas(dat: HashMap<Int, String>, clas:HashMap<Int,String>, g:HashMap<Int,String>,c:HashMap<Int,String>){
        this.data=dat
        this.data_clase = clas
        this.nota= g
        this.mF=c
        println("ESTO ES "+this.data_clase.toString())
        println("ESTO ES "+this.data.toString())
        println("ESTO ES "+this.nota.toString())
        println("ESTO ES"+ cantidad.toString())
    }

    private val titles = arrayOf(
            "Registrar Alumno", "Registrar Clase",
            "Matricula", "Ingresar Notas",
            "Enviar Matricula", "Enviar Nota", "Salir"
    )

    private val details = arrayOf(
            "Registrar un Alumno  ",
            "Registrar las Clases",
            "Realizar Matricula",
            "Ingreso de Notas",
            "Enviar Matricula por Correo",
            "Enviar nota por Correo",
            "Cerrar sesion"

    )

    private val images = intArrayOf(
            R.drawable.image2,
            R.drawable.imagen1, R.drawable.clases,
            R.drawable.images3, R.drawable.images4,
            R.drawable.image5,R.drawable.cerrar,
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
                var position:Int = getAdapterPosition()
                println(position.toString())


                when(position){
                    0 -> GoRegistrarAlumno(itemView)
                    1 -> GoRegistrarClase(itemView)
                    2 -> GoMatricula(itemView)
                    3 -> GoIngresarNotas(itemView)
                    4 -> GoEnviarMatricula(itemView)
                    5 -> GoEnviarNota(itemView)
                    6 -> GoCerrar(itemView)
                    else->GoMain(itemView)

                }





            }


        }


    }
    private fun GoCerrar(itemView: View){
        val p = Process.myPid()
        Process.killProcess(p)
        val intent = Intent(itemView.context, p::class.java)
        itemView.context.startActivity(intent)

    }

    private fun GoMain(itemView: View){
        val intent = Intent(itemView.context, MainActivity::class.java)
        itemView.context.startActivity(intent)

    }

    private fun GoEnviarNota(itemView: View) {
        val intent = Intent(itemView.context, EnviarNotas::class.java)
        intent.putExtra("notas",nota)
        itemView.context.startActivity(intent)

    }

    fun GoRegistrarAlumno(itemView: View){
        val intent = Intent(itemView.context, RegistrarAlumno::class.java)
        itemView.context.startActivity(intent)

    }

    fun GoMatricula(itemView: View){
        val intent = Intent(itemView.context, RealizarMatricula::class.java)
        intent.putExtra("alumno", data)
        intent.putExtra("clases",data_clase)
        intent.putExtra("cant", cantidad)
        itemView.context.startActivity(intent)

    }

    fun GoEnviarMatricula(itemView: View){
        val intent = Intent(itemView.context, EnviarMatriculaCorreo::class.java)
        intent.putExtra("set", mF)
        intent.putExtra("go", nota)
        itemView.context.startActivity(intent)


    }

    fun GoIngresarNotas(itemView: View){
        val intent = Intent(itemView.context, IngresarNotas::class.java)
        intent.putExtra("mf",mF)
        itemView.context.startActivity(intent)

    }

    fun GoRegistrarClase(itemView: View){
        val intent = Intent(itemView.context, RegistrarClase::class.java)
        intent.putExtra("studio", data)
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