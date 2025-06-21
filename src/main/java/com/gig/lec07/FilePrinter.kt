package com.gig.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * @author : JAKE
 * @date : 2025/06/21
 */
class FilePrinter {
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    // try-resource 구문 대신 use 구문 사용
    fun readFileTryWithResource(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}