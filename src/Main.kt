fun main() {
    //User Inputs
    val userSpeed = 7
    val userSpeedUnit = "MB/s"
    val userSize = 45
    val userSizeUnit = "GB"
    // val userTolerance = 2 +/- MB/s

    //Call Calc Function
    val tempTimeInSeconds: Long = calc(userSize, userSpeed, userSpeedUnit, userSizeUnit)

    //Print OutPut
    timeOutput(tempTimeInSeconds)
    println("NOTE: Times shown are Approximate")

}
//Function for Compiling the UserInput
fun userInput(){

}


//Function Used to Convert the Size or Speed into Bytes
fun unitConversion(unit: String): Long {
    return when (unit) {
        //Bytes
        "TB", "TB/s" -> 1000000000000L
        "GB", "GB/s" -> 1000000000L
        "MB", "MB/s" -> 1000000L
        "KB", "KB/s" -> 1000L
        "B", "B/s" -> 1
        //Bits to Bytes
        "Tbps" -> (1000000000000L / 8)
        "Gbps" -> (1000000000L / 8)
        "Mbps" -> (1000000L / 8)
        "Kbps" -> (1000L / 8)
        "bps" -> (1 / 8)
        else -> {
            1
        }
    }
}

//Function to actually Calculate the Time in Seconds.
fun calc(size: Int, speed: Int, speedUnit: String, sizeUnit: String): Long {

    val speedCalc: Long = speed * unitConversion(speedUnit)
    val sizeCalc: Long = size * unitConversion(sizeUnit)
    val timeInSeconds = sizeCalc / speedCalc

    println("Speed is $speed $speedUnit and the Size is $size $sizeUnit")
    return timeInSeconds
}

//Function to Output the Time
fun timeOutput(timeInSeconds: Long): Boolean {

    //Years
    if (timeInSeconds >= 3.15E7) {
        println("The Duration is over a year long")
        return true
    }

    //Hours
    val doubleHours: Double = (timeInSeconds.toDouble() / 3600)
    val hours = doubleHours.toInt()
    //Minutes
    val doubleMinutes: Double = ((timeInSeconds.toDouble() / 3600) - hours) * 60
    val minutes = doubleMinutes.toInt()
    //Seconds
    val doubleSeconds: Double = (doubleMinutes - minutes) * 60
    val seconds = doubleSeconds.toInt()

    //OutPut
    println("The Duration is $hours Hours, $minutes Minutes, $seconds Seconds")
    return true
}