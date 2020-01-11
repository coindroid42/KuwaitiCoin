package io.horizontalsystems.bankwallet.core.managers

import io.horizontalsystems.bankwallet.BuildConfig
import io.horizontalsystems.bankwallet.R
import io.horizontalsystems.bankwallet.core.App
import io.horizontalsystems.bankwallet.core.IAppConfigProvider
import io.horizontalsystems.bankwallet.core.IPredefinedAccountType
import io.horizontalsystems.bankwallet.entities.*
import java.math.BigDecimal

class AppConfigProvider : IAppConfigProvider {
    override val companyWebPageLink: String = "https://horizontalsystems.io"
    override val appWebPageLink: String = "https://horizontalsystems.com"
    override val reportEmail = "horizontalsystems@protonmail.ch"
    override val reportTelegramGroup = "horizontalsystems_wallet"
    override val ipfsId = "QmXTJZBMMRmBbPun6HFt3tmb3tfYF2usLPxFoacL7G5uMX"
    override val ipfsMainGateway = "ticker.coindroid.org"
    override val ipfsFallbackGateway = "ticker.coindroid.org"

    override val infuraProjectId = "2a1306f1d12f4c109a4d4fb9be46b02e"
    override val infuraProjectSecret = "fc479a9290b64a84a15fa6544a130218"

    override val fiatDecimal: Int = 2
    override val maxDecimal: Int = 8

    override val testMode: Boolean = BuildConfig.testMode

    override val currencies: List<Currency> = listOf(
            Currency(code = "USD", symbol = "\u0024"),
            Currency(code = "EUR", symbol = "\u20AC"),
            Currency(code = "GBP", symbol = "\u00A3"),
            Currency(code = "JPY", symbol = "\u00A5"),
            Currency(code = "AUD", symbol = "\u20B3"),
            Currency(code = "CAD", symbol = "\u0024"),
            Currency(code = "CHF", symbol = "\u20A3"),
            Currency(code = "CNY", symbol = "\u00A5"),
            Currency(code = "KRW", symbol = "\u20AE"),
            Currency(code = "RUB", symbol = "\u20BD"),
            Currency(code = "TRY", symbol = "\u20BA")
    )

    override val localizations: List<String>
        get() {
            val coinsString = App.instance.getString(R.string.localizations)
            return coinsString.split(",")
        }
    override val defaultCoinCodes: List<String>
        get() = listOf("ETH")

    override val featuredCoins: List<Coin>
        get() = listOf(
                coins[0],
                coins[1],
                coins[2],
                coins[3],
                coins[4]
        )

    override val coins: List<Coin> = listOf(
            Coin("BTC",       "Bitcoin",                 "BTC",          8,      CoinType.Bitcoin),
            Coin("ETH",       "Ethereum",                "ETH",         18,      CoinType.Ethereum),
            Coin("Q8E20",       "Q8E20 Token",                   "Q8E20",         8,      CoinType.Erc20("0xa31f7a32db329f270a0e6b59558823e64d8ef0a6")),
            Coin("GOLDR",       "Golden Ratio Coin",                   "GOLDR",         8,      CoinType.Erc20("0xcfe4f03c3afbb9857b29fc706180bf0044900d59")),
            Coin("TCHO",       "Tech Co",                   "TCHO",         8,      CoinType.Erc20("0x16fb30551fa8e600710ae17fd287d428edd462b6")),
            Coin("DDRT",       "DigiDinar Token",                   "DDRT",         8,      CoinType.Erc20("0x94501b6A153C8973fd1f321fCC8188d40dC5d72d"))
    )

    override val predefinedAccountTypes: List<IPredefinedAccountType> = listOf(
            UnstoppableAccountType()
            //EosAccountType(),
            //BinanceAccountType()
    )
}
