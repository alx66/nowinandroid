/*
 * Copyright 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.ui.lesson15.homework

import com.google.samples.apps.nowinandroid.ui.lesson15.BaseClass
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

@HiltAndroidTest
class SearchScreenTests : BaseClass() {
    @Test
    fun checkNavBarInSearchScreen() {
        run {
            MainScreen {
                step("Переход с основного экрана на экран поиска") {
                    searchButton.performClick()
                }
            }
            SearchScreen {
                step("Проверка наличия кнопки возвращения в основной экран") {
                    backButton.assertIsDisplayed()
                }
                step("Проверка наличия строки поиска") {
                    searchTextField.assertIsDisplayed()
                }
                step("Проверка наличия иконки в строке поиска") {
                    iconInSearchField.assertIsDisplayed()
                }
                step("Ввод текста в поле поиска") {
                     searchTextField.performClick()
                    searchTextField.performTextInput("test")
                    Thread.sleep(5000)
                }

            }
        }
    }
}