@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    return when {
        ((age>0)&&(age<200)&&((age%10==1)||((age%100)%10==1))&&(age!=11)&&(age!=111))
            -> ("$age год")
        ((age>0)&&(age<100)&&((age%10==2)||(age%10==3)||(age%10==4))
                &&(age!=11)&&(age!=12)&&(age!=13)&&(age!=14))
            -> ("$age года")
        ((age>99)&&(age<200)&&(((age%100)%10==2)||((age%100)%10==3)
                ||((age%100)%10==4))&&(age!=111)&&(age!=112)&&(age!=113)&&(age!=114))
            -> ("$age года")
        else -> ("$age лет")
    }
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val halfs=(t1*v1+t2*v2+t3*v3)/2
    return when {
        (t1*v1>=halfs) -> halfs/v1
        (t1*v1+t2*v2>=halfs) -> t1+(halfs-t1*v1)/v2
        else -> t1+t2+(halfs-t1*v1-t2*v2)/v3
    }
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    return when {
        ((kingX!=rookX2)&&(kingY!=rookY2)&&(((kingX==rookX1)&&
                (kingY!=rookY1))||((kingX!=rookX1)&&(kingY==rookY1)))) -> 1
        ((kingX!=rookX1)&&(kingY!=rookY1)&&(((kingX==rookX2)&&
                (kingY!=rookY2))||((kingX!=rookX2)&&(kingY==rookY2)))) -> 2
        ((kingX!=rookX1)&&(kingY!=rookY1)&&(kingX!=rookX2)&&(kingY!=rookY2)) -> 0
        else -> 3

    }
}



/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    return when {
        ((kingX==rookX)||(kingY==rookY))&&(((kingX-kingY)==(bishopX-bishopY))
                ||((kingX+kingY)==(bishopX+bishopY))) -> 3
        (kingX==rookX)||(kingY==rookY) -> 1
        ((kingX-kingY)==(bishopX-bishopY))
                ||((kingX+kingY)==(bishopX+bishopY)) -> 2
        else -> 0
    }
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    return when {
        (a>=b+c)||(b>=a+c)||(c>=a+b) -> -1
        (a*a<b*b+c*c)&&(b*b<a*a+c*c)&&(c*c<a*a+b*b) -> 0
        (a*a==b*b+c*c)||(b*b==a*a+c*c)||(c*c==a*a+b*b) -> 1
        else -> 2
    }

}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    return when{
        (d>=b)&&(c>=a)&&(b>=c) -> b-c
        (a<=c)&&(c<=b)&&(d<=b) -> d-c
        (a>=c)&&(b<=d) -> b-a
        (a>=c)&&(d>=a)&&(b>=d) -> d-a
        else -> -1
    }

}
