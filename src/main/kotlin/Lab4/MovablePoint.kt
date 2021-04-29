package Lab4

class MovablePoint(var xSpeed: Float = 0f, var ySpeed: Float = 0f, x: Float = 0f, y: Float = 0f): Point(x, y) {
    fun setSpeed(xSpeed: Float, ySpeed: Float){
        this.xSpeed = xSpeed
        this.ySpeed = ySpeed
    }

    fun getSpeed(): Array<Float> = arrayOf(xSpeed, ySpeed)

    override fun toString(): String = super.toString() + ", speed=($xSpeed, $ySpeed)"

    fun move(): MovablePoint{
        x += xSpeed
        y += ySpeed
        return this
    }
}