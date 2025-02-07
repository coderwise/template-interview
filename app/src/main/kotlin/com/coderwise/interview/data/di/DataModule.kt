package com.coderwise.interview.data.di

import com.coderwise.interview.data.ItemsRepository
import com.coderwise.interview.data.ItemsRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<ItemsRepository> { ItemsRepositoryImpl() }
}