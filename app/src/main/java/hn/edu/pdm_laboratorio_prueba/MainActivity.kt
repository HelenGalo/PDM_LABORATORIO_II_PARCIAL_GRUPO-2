package hn.edu.pdm_laboratorio_prueba
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerAdapter = RecyclerAdapter()
    var  data: HashMap<Int, String> = hashMapOf()
    var  a: HashMap<Int, String> = hashMapOf()
    var  data_clases: HashMap<Int, String> = hashMapOf()
    var status:String="false"
    var cont:Int = 0
    var estado_Clase="false"
    var estado_nota="false"
    var estadof="true"
    var nota:HashMap<Int, String> = hashMapOf()
    var mf:HashMap<Int, String> = hashMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        collapsing_toolbar.title = "UJCV"
        collapsing_toolbar.setContentScrimColor(Color.BLACK)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter=adapter





        validar()
        println("THIS IS" +status.toString())






    }

    fun validar(){
        var tem=getVariable().toString()
        var intent = intent
        if(tem=="true"){
            data = intent.getSerializableExtra("listado") as HashMap<Int, String>
            println(data.toString())
            goAlum(obt())
        }

        var estadotem=getEstadoCLase().toString()
        var estadof = getEstadoF().toString()
        var f = getEstadoNota().toString()
        if(estadotem=="true"){
            getClases()
            getCantidad()
            adapter.enviarClases(data,data_clases,cont)


        }

        println("El estado f es: " +estadof.toString() +"Y f es: "+f.toString())



        if(estadof=="false" ){
            a=getMatriculaFinal()
            println("LA MATRICULAS ES"+ a.toString())
            adapter.enviarm(a)

        }
        println("ESTADO FINAL:"+ getStateFin().toString())

        if(getStateFin()=="true"){
            var intent = intent
            nota = intent.getSerializableExtra("no") as HashMap<Int, String>
            mf = intent.getSerializableExtra("alm") as HashMap<Int, String>
            println("LAS NOTAS SON: "+nota.toString()+ "Y LA MATRICULA"+mf.toString())
            adapter.enviarDatos1(mf,nota)
        }

        if(estadodecorreo().toString()=="true"){
            nota =sendNo()
            adapter.enviarDatos1(mf,nota)
        }







    }



    fun getVariable(): String {
        val bundle = intent.extras
        val pala = bundle?.get("status")
        this.status = getString(R.string.txvpalabraoficial, pala)
        return status

    }

    fun getMatriculaFinal(): HashMap<Int, String> {
        var intent = intent
        var m_Final = intent.getSerializableExtra("m") as HashMap<Int, String>
        return m_Final

    }

    fun getCantidad(){
        val bundle = intent.extras
        val pala = bundle?.get("cantidad")
        this.cont = getString(R.string.txvpalabraoficial, pala).toInt()
        println("CONTADOR"+cont.toString())
    }

    fun getEstadoCLase():String{
        val bundle = intent.extras
        val pala = bundle?.get("ESTADOCLASE")
        this.estado_Clase = getString(R.string.txvpalabraoficial, pala)
        return estado_Clase

    }

    fun getStateFin():String{
        val bundle = intent.extras
        val pala = bundle?.get("state")
        var e = getString(R.string.txvpalabraoficial, pala)
        return e

    }

    fun getEstadoF():String{
        val bundle = intent.extras
        val pala = bundle?.get("goahead")
        var p = getString(R.string.txvpalabraoficial, pala)
        return p

    }


    fun getEstadoNota():String{
        val bundle = intent.extras
        val pala = bundle?.get("estadonota")
        var tem = getString(R.string.txvpalabraoficial, pala)
        return tem


    }

    fun estadodecorreo():String{
        val bundle = intent.extras
        val pala = bundle?.get("send")
        var tem = getString(R.string.txvpalabraoficial, pala)
        return tem
    }

    fun sendNo(): HashMap<Int, String> {
        var intent = intent
        var a = intent.getSerializableExtra("end") as HashMap<Int, String>
        return a
    }


    fun goAlum(v:HashMap<Int, String>){

        adapter.enviarDatos(v)





    }

    fun getClases(){
        var intent = intent
        data_clases = intent.getSerializableExtra("clases") as HashMap<Int, String>
        data = intent.getSerializableExtra("alumno") as HashMap<Int, String>

        println("LAS CLASES SON "+data_clases.toString())
        println("El alumno es "+ data.toString())


    }


    fun getNotas(){
        nota = intent.getSerializableExtra("notas") as HashMap<Int, String>
        println("notas "+ nota.toString())
    }

    fun obt():HashMap<Int, String>{

        return data
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}