package com.formationandroid.services

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.formationandroid.services.CompteurService.MonBinder

class DetailActivity : AppCompatActivity()
{

    // Service :
    private var compteurService: CompteurService? = null

    // Vues :
    private var buttonCompteur: Button? = null


    /**
     * Callback pour le binding, via un ServiceConnection.
     */
    private val connexion: ServiceConnection = object : ServiceConnection
    {
        override fun onServiceConnected(className: ComponentName, binder: IBinder)
        {
            // récupération du service :
            compteurService = (binder as MonBinder).service

            // actualisation du libellé du bouton :
            val valeur = compteurService!!.getCompteur().toString()
            buttonCompteur!!.text = valeur
        }

        override fun onServiceDisconnected(className: ComponentName)
        {
            compteurService = null
        }
    }


    override fun onCreate(savedInstanceState: Bundle?)
    {
        // init :
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // vues :
        buttonCompteur = findViewById(R.id.bouton_compteur)
    }

    override fun onStart()
    {
        super.onStart()

        // binding au service, pour avoir une référence sur ce dernier :
        val intent = Intent(this, CompteurService::class.java)
        bindService(intent, connexion, BIND_AUTO_CREATE)
    }

    /**
     * Listener clic bouton compteur.
     * @param view Bouton
     */
    fun onClickCompteur(view: View?)
    {
        val valeur = compteurService!!.getCompteurIncremente().toString()
        buttonCompteur!!.text = valeur
    }

    override fun onStop()
    {
        super.onStop()

        if (compteurService != null)
        {
            // déconnexion du service :
            unbindService(connexion)
        }
    }

}