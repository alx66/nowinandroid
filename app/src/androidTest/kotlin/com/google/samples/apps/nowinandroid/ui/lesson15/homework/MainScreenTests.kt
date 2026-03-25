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
class MainScreenTests : BaseClass() {
    @Test
    fun checkToolBarHasText() {
        run {
            MainScreen {
                step("Проверка тайтле навбара") {
                    toolbarTitle.assertTextEquals("Now in Android")
                }
                step("Проверка наличия кнопки поиска в навбаре") {
                    searchButton.assertIsDisplayed()
                }
                step("Проверка наличия кнопки настроек") {
                    settingsButton.assertIsDisplayed()
                }
                step("Проверка текста в тайтле над списком") {
                    titleTextUnderList.assertTextEquals("What are you interested in?")
                }
                step("Проверка текст в сабтайтле над списком") {
                    subtitleTextUnderList.assertTextContains("Updates from topics", substring = true, ignoreCase = false)
                } // как сделать через assertTextContains?
                step("Проверка отображения кнопки done") {
                    doneButton.assertIsDisplayed()
                }
                step("Проверка текста в кнопке done") {
                    doneButtonText.assertTextEquals("Done")
                }
            }
        }
    }
}
