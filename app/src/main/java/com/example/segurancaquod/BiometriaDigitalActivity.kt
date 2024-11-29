package com.example.segurancaquod

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class BiometriaDigitalActivity : AppCompatActivity() {

    private lateinit var ivDigital: ImageView
    private lateinit var tvStatus: TextView
    private lateinit var btnSimularCaptura: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biometria_digital)

        // Vincular os elementos da interface
        ivDigital = findViewById(R.id.ivDigital)
        tvStatus = findViewById(R.id.tvStatus)
        btnSimularCaptura = findViewById(R.id.btnSimularCaptura)

        // Aplicar animação no ImageView
        val animation = AnimationUtils.loadAnimation(this, R.anim.fingerprint_animation)
        ivDigital.startAnimation(animation)

        // Configurar clique no botão
        btnSimularCaptura.setOnClickListener {
            iniciarSimulacao()
        }
    }

    private fun iniciarSimulacao() {
        // Alterar status para "capturando"
        tvStatus.text = "Capturando digital..."
        ivDigital.setColorFilter(resources.getColor(R.color.teal_700, theme)) // Troca a cor para indicar captura
        btnSimularCaptura.isEnabled = false

        // Simular tempo de processamento
        Handler(Looper.getMainLooper()).postDelayed({
            exibirResultado()
        }, 3000) // Aguardar 3 segundos
    }

    private fun exibirResultado() {
        // Simular sucesso ou falha aleatoriamente
        val sucesso = (0..1).random() == 1

        if (sucesso) {
            tvStatus.text = "Digital validada com sucesso!"
            ivDigital.setColorFilter(resources.getColor(R.color.green, theme)) // Cor verde para sucesso
            Snackbar.make(btnSimularCaptura, "Validação bem-sucedida!", Snackbar.LENGTH_LONG).show()
        } else {
            tvStatus.text = "Falha na validação da digital!"
            ivDigital.setColorFilter(resources.getColor(R.color.red, theme)) // Cor vermelha para falha
            Snackbar.make(btnSimularCaptura, "Validação falhou. Tente novamente!", Snackbar.LENGTH_LONG).show()
        }

        btnSimularCaptura.isEnabled = true
    }
}
