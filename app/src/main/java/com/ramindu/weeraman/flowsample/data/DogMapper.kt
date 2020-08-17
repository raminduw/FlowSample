package com.ramindu.weeraman.flowsample.data

import com.ramindu.weeraman.flowsample.data.model.Dog
import com.ramindu.weeraman.flowsample.domain.Mapper
import javax.inject.Inject

class DogMapper @Inject constructor() : Mapper<String, Dog> {
    override fun transform(model: String): Dog {
        return Dog(model)
    }
}