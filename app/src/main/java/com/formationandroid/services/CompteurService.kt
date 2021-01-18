package com.formationandroid.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class CompteurService : Service()
{

    // Binder :
    private val binder: IBinder = MonBinder()

    // Compteur :
    private var compteur = 0


    override fun onBind(intent: Intent?): IBinder?
    {
        return binder
    }

    /**
     * Getter compteur.
     * @return compteur
     */
    fun getCompteur(): Int = compteur

    /**
     * Getter compteur incrémenté.
     * @return compteur
     */
    fun getCompteurIncremente(): Int
    {
        compteur++
        return compteur
    }


    /**
     * Classe binder.
     */
    inner class MonBinder : Binder()
    {
        /**
         * Getter service.
         * @return CompteurService
         */
        val service: CompteurService
            get() = this@CompteurService
    }

}