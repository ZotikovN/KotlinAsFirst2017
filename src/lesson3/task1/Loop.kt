@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var x = 1
    var i = n
    if (i==0) return 1
    while (i/10!=0){
        i=i/10
        x+=1
    }
    return x
}


/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var no1: Int = 1
    var no2: Int = 1
    var fib: Int = 0
    var m: Int = 2
    if (n<=m) return 1
    else {
        while (n > m){
            fib = no1 + no2
            no1 = no2
            no2 = fib
            m +=1
        }
        return fib
    }
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int = m * n / algEu(m, n)
/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    val n1: Double = Math.ceil(Math.sqrt(n.toDouble()))
    var k=2
    do {
        when (n % k == 0) {
            true -> return k
        }
        k+=1
    } while (k <= n1)
    return n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    val k = n / minDivisor(n)
    return k
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = algEu(m, n) == 1

fun algEu(y: Int, x: Int): Int {
    var DivMax = 0
    var m = y
    var n = x
    do {
        when ((Math.max(m, n) % Math.min(m, n)) == 0 ) {
            true -> DivMax = Math.min(m, n)
            false -> when (n < m) {
                true -> m %= n
                false -> n %= m
            }
        }
    } while (DivMax == 0)
    return DivMax
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var k = 1
    when (m == 0){
        true -> return true
        false -> {
            while (k<=n/k) {
                if (k.toDouble()>=m.toDouble()/k.toDouble()) return true
                k+=1
            }
        }
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var x = n
    var s: Int = 0
    var num: Int = 0
    var z: Int = 0
    z = digitNumber(n) - 1
    for (i in 1..digitNumber(n)) {
        s = Math.pow(10.0,(z).toDouble()).toInt() * (x % 10)
        x /= 10
        z -= 1
        num += s
    }
    return num
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = TODO()

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var no: Int = 1
    var k: Int = 0
    var t: Int = 0
    var count: Int = 0
    var result: Int = 0
    while (count < n) {
        k = no * no
        no += 1
        count = digitNumber(k) + count
    }
    t = count - n
    if (t != 0)
        k = k / Math.pow(10.0, t.toDouble()).toInt()
    result = k % 10
    return result
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var no1: Int = 1
    var no2: Int = 1
    var f: Int = 0
    var m: Int = 0
    var count: Int = 2
    var result: Int = 0
    if ((n == 2)||(n == 1)) return 1
    while (count < n) {
        f = no1 + no2
        count = count + digitNumber(f)
        no1 = no2
        no2 = f
    }
    m = count - n
    if (m != 0)
        f = f / Math.pow(10.0, m.toDouble()).toInt()
    result = f % 10
    return result
}