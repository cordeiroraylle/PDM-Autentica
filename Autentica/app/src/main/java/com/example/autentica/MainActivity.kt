
package com.example.autentica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var user: EditText
    private lateinit var pass: EditText
    private lateinit var btok: Button
    private lateinit var btcancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.user = findViewById(R.id.user)
        this.pass = findViewById(R.id.pass)
        this.btok = findViewById(R.id.btok)
        this.btcancelar = findViewById(R.id.btcancelar)

        this.btcancelar.setOnClickListener({
            Log.i("app autentica", "i - Cancelou")
            Log.e("app autentica", "e - Cancelou")
            Log.w("app autentica", "w - Cancelou")
            this.user.text.clear()
            this.pass.text.clear()
            Toast.makeText(this,"Você cancelou", Toast.LENGTH_SHORT).show()
        })

        this.btok.setOnClickListener(OnClickBotao())
    }

    inner class OnClickBotao : View.OnClickListener{
        override fun onClick(v: View?) {
            var usuario = this@MainActivity.user.text.toString()
            var senha = this@MainActivity.pass.text.toString()

            Log.i("app autentica", "$usuario - $senha")

            if (usuario == "admin" && senha == "1234") {
                Toast.makeText(this@MainActivity, "Sucesso :D", Toast.LENGTH_SHORT).show()
                Log.i("app autentica", "Deu certo")

                setContentView(R.layout.activity_sucesso)

            }else{
                Toast.makeText(this@MainActivity, "deu errado D:", Toast.LENGTH_SHORT).show()
                Log.e("app autentica:", "Deu errado")
            }
        }
    }
}