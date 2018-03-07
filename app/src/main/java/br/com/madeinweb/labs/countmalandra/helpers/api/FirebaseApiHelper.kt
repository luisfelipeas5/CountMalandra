package br.com.madeinweb.labs.countmalandra.helpers.api

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable

class FirebaseApiHelper(private val mFirebaseDatabase: FirebaseDatabase): ApiContractHelper {

    override fun getTotal(): Observable<Int> {
        val counterRef = mFirebaseDatabase.getReference("total")
        return Observable.create { emitter ->
            counterRef.addValueEventListener(object: ValueEventListener{
                override fun onCancelled(databaseError: DatabaseError?) {
                    databaseError?.let {
                        emitter.tryOnError(Exception(databaseError.message))
                    }
                    emitter.onComplete()
                }

                override fun onDataChange(dataSnapshot: DataSnapshot?) {
                    dataSnapshot?.let {
                        val totalInteger = dataSnapshot.getValue(Integer::class.java)
                        var total = 0
                        if (totalInteger != null) {
                            total = totalInteger.toInt()
                        }
                        emitter.onNext(total)
                    }
                }

            })
        }
    }
}