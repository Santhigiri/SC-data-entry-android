package com.example.sc_data_entry.utils

import com.example.sc_data_entry.models.Significance
import com.example.sc_data_entry.models.SignificanceType

class SignificanceFactory{
    fun getSignificance(significanceType: SignificanceType): Significance =
        when(significanceType){
            SignificanceType.POURNAMI -> Significance(
                id = 1,
                name = "Pournami",
                type = SignificanceType.POURNAMI,
                description = "Pournami Description"
            )
            SignificanceType.CHOTHI -> Significance(
                id = 2,
                name = "Chothi",
                type = SignificanceType.CHOTHI,
                description = "Chothi Description"
            )
            SignificanceType.POORNA_KUMBAMELA -> Significance(
                id = 3,
                name = "Poorna Kumbamela",
                type = SignificanceType.POORNA_KUMBAMELA,
                description = "Poorna Kumbamela Description"
            )
        }
    }
