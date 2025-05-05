package julia.com.github.android_crypto_monitor

    class TickerResponse (
        val ticker: Ticker
    )

    //passa pelo construtor
class Ticker(
        val high: String,
        val low: String,
        val vol: String,
        val last: String,
        val buy: String,
        val sell: String,
        val date: Long
    )
