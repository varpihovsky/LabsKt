package Lab4

open class Point(var x: Float = 0f, var y: Float = 0f) {
    fun setXY(x: Float, y: Float){
        this.x = x
        this.y = y
    }

    fun getXY():Array<Float> = arrayOf(x, y)

    override fun toString(): String = "($x, $y)"
}