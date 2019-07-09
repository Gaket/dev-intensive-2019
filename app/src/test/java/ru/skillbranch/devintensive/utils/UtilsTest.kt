package ru.skillbranch.devintensive.utils

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Artur (gaket) on 2019-07-02.
 */
class UtilsTest {

    @Test
    fun parseFullName() {
        val (f, l) = Utils.parseFullName("Art Bad")
        assertEquals(f, "Art")
        assertEquals(l, "Bad")
    }

    @Test
    fun parseEmtpyName() {
        val (f, l) = Utils.parseFullName("")
        assertNull(f)
        assertNull(l)
    }

    @Test
    fun parseSpaceName() {
        val (f, l) = Utils.parseFullName(" ")
        assertNull(f)
        assertNull(l)
    }

    @Test
    fun parseHalfName() {
        val (f, l) = Utils.parseFullName("Art")
        assertEquals(f, "Art")
        assertNull(l)
    }

    @Test
    fun translitLower() {
        val trans = Utils.transliteration("артур")
        assertEquals("artur", trans)
    }

    @Test
    fun translit() {
        val trans = Utils.transliteration("Артур")
        assertEquals("Artur", trans)
    }


    @Test
    fun translit2words() {
        val trans = Utils.transliteration("Артур бАд")
        assertEquals("Artur bAd", trans)
    }

    @Test
    fun translit2langWords() {
        val trans = Utils.transliteration("Артур BAD 2")
        assertEquals("Artur BAD 2", trans)
    }
}