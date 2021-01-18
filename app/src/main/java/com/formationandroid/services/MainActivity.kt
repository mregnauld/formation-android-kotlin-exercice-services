package com.formationandroid.services

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{

	override fun onCreate(savedInstanceState: Bundle?)
	{
		// init :
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// démarrage service
		val intentService = Intent(this, CompteurService::class.java)
		startService(intentService)
	}

	/**
	 * Listener clic bouton compteur.
	 * @param view Bouton
	 */
	fun onClickCompteur(view: View?)
	{
		val intent = Intent(this, CompteurJobIntentService::class.java)
		CompteurJobIntentService.enqueueWork(this, intent)
	}

	/**
	 * Listener clic bouton page secondaire.
	 * @param view Bouton
	 */
	fun onClickPageSecondaire(view: View?)
	{
		val intent = Intent(this, DetailActivity::class.java)
		startActivity(intent)
	}

}