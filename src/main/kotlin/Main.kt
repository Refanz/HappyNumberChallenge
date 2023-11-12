import java.util.Scanner
import kotlin.math.pow

//TODO Bagian 1: Membuat fungsi terpisah untuk menghitung jumlah kuadrat masukkan
fun calcSquares(num: String): Int {
    var result = 0

    for (elm in num) {
        result += Integer.parseInt(elm.toString()).toDouble().pow(2.0).toInt()
    }

    return result
}

//TODO Bagian 2: Membuat fungsi terpisah untuk mengecek apakah hasil penjumlahan kuadrat angka adalah happy number
fun Int.isHappyNumber(): Boolean {
    return this == 1
}

//TODO Bagian 3: Membuat fungsi untuk melakukan perhitungan angka
fun isResultOne(num: String): Boolean {
    val listResult = ArrayList<Int>()

    listResult.add(calcSquares(num))

    var count = 0

    while (true) {
        if (!listResult[count].isHappyNumber()) {
            val temp = calcSquares(listResult[count].toString())

            if (temp in listResult) {
                return false
            }

            listResult.add(temp)

        } else {
            return true
        }

        count++
    }
}



//TODO Bagian 4: Membuat fungsi utama untuk menjalankan program
fun main() {
    val input = Scanner(System.`in`)

    print("Masukkan angka: ")
    val num = input.next()

    println(isResultOne(num))
}

/*
    Pada program ini dibuat 3 fungsi terpisah yaitu calcSquares(), isHappyNumber(), dan isResultOne().
    Berikut ini penjelasan time complexity dan space complexity pada fungsi yang telah dibuat di atas:

    a) calcSquares()
       Time Complexity: Fungsi ini melakukan iterasi berdasarkan panjang dari angka yang dimasukkan user,
                        sehingga time complexity-nya adalah O(n), dengan n adalah panjang angka.
       Space Complexity: Fungsi ini memiliki variabel lokal yaitu result yang hanya menyimpan 1 nilai,
                         sehingga space complexity-nya adalah O(1).

     b) isHappyNumber()
       Time Complexity: Fungsi ini tidak melakukan iterasi apapun dan hanya melakukan pengecekan,
                        sehingga time complexity-nya adalah O(1).
       Space Complexity: Fungsi ini tidak terdapat pembuatan variabel apapun di dalamnya, sehingga
                         space complexity-nya adalah O(1).

      c) isResultOne()
       Time Complexity: Fungsi ini melakukan iterasi hingga ditemukan hasil 1 jadi time complexity-nya
                        dapat menjadi O tak hingga.
       Space Complexity: Fungsi ini memiliki variabel lokal yaitu listResult yang akan terus bertambah nilainya
                         sampai hasil adalah 1 atau terdapat cycle pada perhitungan, sehingga space complexity-nya
                         adalah O(n), dengan n adalah banyaknya element dalam array.
 */