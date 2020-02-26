package android.latihan.widget_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgBtn = findViewById<ImageButton>(R.id.imgButtonAdd)
        val nama = findViewById<EditText>(R.id.editNama)
        val radioGroup = findViewById<RadioGroup>(R.id.genderGroup)
        val coding = findViewById<CheckBox>(R.id.checkCoding)
        val reading = findViewById<CheckBox>(R.id.checkReading)
        val travel = findViewById<CheckBox>(R.id.checkTravel)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            var text = ""
            text += if (R.id.radioLaki == checkedId) "Dipilih : Laki-Laki"  else if (R.id.radioPerempuan == checkedId) "Dipilih : Perempuan" else ""
            Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
        }

        coding.setOnCheckedChangeListener { buttonView, isChecked ->
            if (coding.isChecked){
                var txt = "Anda memilih hobi ${coding.text}"
                message(txt)
            }else{
                var txt = "Anda membatalkan memilih hobi ${coding.text}"
                message(txt)
            }
        }

        reading.setOnCheckedChangeListener { buttonView, isChecked ->
            if (reading.isChecked){
                var txt = "Anda memilih hobi ${reading.text}"
                message(txt)
            }else{
                var txt = "Anda membatalkan memilih hobi ${reading.text}"
                message(txt)
            }
        }

        travel.setOnCheckedChangeListener { buttonView, isChecked ->
            if (travel.isChecked){
                var txt = "Anda memilih hobi ${travel.text}"
                message(txt)
            }else{
                var txt = "Anda membatalkan memilih hobi ${travel.text}"
                message(txt)
            }
        }

        imgBtn.setOnClickListener{
            var id: Int = radioGroup.checkedRadioButtonId
            if (id != -1){
                val radio: RadioButton = findViewById(id)
                Toast.makeText(this@MainActivity, "Nama : ${nama.text}, Gender : ${radio.text} telah berhasil disimpan", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this@MainActivity, "Harap Lengkapi data terlebih dahulu", Toast.LENGTH_LONG).show()
            }

        }


        val reset = findViewById<ImageButton>(R.id.imgButtonCancel)
        reset.setOnClickListener {
            nama.text.clear()
            radioGroup.clearCheck()
            checkCoding.isChecked=false
            checkReading.isChecked=false
            checkTravel.isChecked=false
        }
//

    }
    fun message(str: String){
        Toast.makeText(this, str , Toast.LENGTH_LONG).show()
    }
}
