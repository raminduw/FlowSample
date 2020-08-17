package com.ramindu.weeraman.flowsample.domain

interface Mapper<IN, OUT> {
    fun transform(model: IN): OUT
}