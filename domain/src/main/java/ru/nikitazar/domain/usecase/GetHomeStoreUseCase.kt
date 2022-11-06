package ru.nikitazar.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.nikitazar.domain.model.HomeStoreSmartphone
import ru.nikitazar.domain.repository.PhoneRepository

class GetHomeStoreUseCase(
    private val repository: PhoneRepository
) {
    suspend fun execute(): Flow<List<HomeStoreSmartphone>> = repository.dataHomeStore
}