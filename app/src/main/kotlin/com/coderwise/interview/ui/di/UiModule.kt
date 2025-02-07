package com.coderwise.interview.ui.di

import com.coderwise.interview.ui.details.DetailsViewModel
import com.coderwise.interview.ui.list.ListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { ListViewModel() }
    viewModel { DetailsViewModel() }
}