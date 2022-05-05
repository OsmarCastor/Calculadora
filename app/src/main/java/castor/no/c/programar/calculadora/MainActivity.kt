package castor.no.c.programar.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    lateinit var txtPantalla:TextView
    var num1 = 0
    var num2 = 0
    var operacion = 0
    lateinit var n0:TextView
    lateinit var n1:TextView
    lateinit var n2:TextView
    lateinit var n3:TextView
    lateinit var n4:TextView
    lateinit var n5:TextView
    lateinit var n6:TextView
    lateinit var n7:TextView
    lateinit var n8:TextView
    lateinit var n9:TextView
    lateinit var suma:TextView
    lateinit var resta:TextView
    lateinit var igual:TextView
    lateinit var clear:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPantalla = findViewById(R.id.txtPantalla)
        n0 = findViewById(R.id.txtNum0)
        n1 = findViewById(R.id.txtNum1)
        n2 = findViewById(R.id.txtNum2)
        n3 = findViewById(R.id.txtNum3)
        n4 = findViewById(R.id.txtNum4)
        n5 = findViewById(R.id.txtNum5)
        n6 = findViewById(R.id.txtNum6)
        n7 = findViewById(R.id.txtNum7)
        n8 = findViewById(R.id.txtNum8)
        n9 = findViewById(R.id.txtNum9)
        suma = findViewById(R.id.txtSuma)
        resta = findViewById(R.id.txtResta)
        igual = findViewById(R.id.txtIgual)
        clear = findViewById(R.id.txtC)

        n0.setOnClickListener{presionaste("0")}
        n1.setOnClickListener{presionaste("1")}
        n2.setOnClickListener{presionaste("2")}
        n3.setOnClickListener{presionaste("3")}
        n4.setOnClickListener{presionaste("4")}
        n5.setOnClickListener{presionaste("5")}
        n6.setOnClickListener{presionaste("6")}
        n7.setOnClickListener{presionaste("7")}
        n8.setOnClickListener{presionaste("8")}
        n9.setOnClickListener{presionaste("9")}
        suma.setOnClickListener{ operacion(1) }
        resta.setOnClickListener{ operacion(2) }

        clear.setOnClickListener{
            num1
            num2
            txtPantalla.text = ""
            operacion = nooperacion
        }
        igual.setOnClickListener{
            var resultado = when(operacion){
                Suma -> num1 + num2
                Resta -> num1 - num2
                else -> num1
            }
            txtPantalla.text = resultado.toString()
            num1=resultado.toString().toInt()
        }
    }
    fun presionaste(digito: String){

        txtPantalla.text = "${txtPantalla.text}$digito"

        if (operacion == nooperacion){
            num1 = txtPantalla.text.toString().toInt()

        } else { num2 = txtPantalla.text.toString().toInt()
        }
    }
    private fun operacion(operacion: Int){
        this.operacion = operacion
        txtPantalla.text = ""
    }
    companion object{
        val  Suma = 1
        val  Resta = 2
        val  nooperacion = 0
    }
}