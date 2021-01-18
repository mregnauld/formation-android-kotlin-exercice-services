package com.formationandroid.services

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class CompteurJobIntentService : JobIntentService()
{

    // Bloc static :
    companion object
    {
        private val TAG: String = CompteurJobIntentService::class.java.simpleName

        fun enqueueWork(context: Context, intent: Intent)
        {
            enqueueWork(context, CompteurJobIntentService::class.java, 1, intent)
        }
    }

    // Compteur :
    private var compteur = 0


    override fun onHandleWork(intent: Intent)
    {
        // attente artificielle de 3 secondes pour simuler un traîtement long :
        try
        {
            Thread.sleep(3000)
        }
        catch (e: InterruptedException)
        {
            e.printStackTrace()
        }

        // incrémentation du compteur et affichage dans les logs :
        compteur++
        Log.i(TAG, "compteur intent service = $compteur")
    }

}