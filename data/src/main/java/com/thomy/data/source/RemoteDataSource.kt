package com.thomy.data.source

import com.thomy.domain.Dog

interface RemoteDataSource {
    suspend fun getDogs():List<Dog>
}