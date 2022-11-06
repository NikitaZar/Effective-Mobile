package ru.nikitazar.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.nikitazar.domain.model.BestsellerSmartphone
import ru.nikitazar.domain.repository.PhoneRepository

class GetBestsellerListUseCase(
    private val repository: PhoneRepository
) {
    suspend fun execute(): Flow<List<BestsellerSmartphone>> = repository.dataBestSeller
}