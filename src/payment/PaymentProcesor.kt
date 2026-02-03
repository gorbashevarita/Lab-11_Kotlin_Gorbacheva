package payment
class PaymentProcesor {
    private val validator = PaymentValidator()

    fun pay(payment: Payment): PaymentResult {
        if (!validator.check(payment)) {
            return PaymentResult.Error(reason = "Ошибка валидации")
        }
        return when (payment.type) {
            CardType.VISA -> PaymentResult.Success(id = "VISA-${System.currentTimeMillis()}")
            CardType.MASTERCARD -> PaymentResult.Processing
            CardType.MIR -> PaymentResult.Success(id = "MIR-${System.currentTimeMillis()}-")
            CardType.UNKNOWN -> PaymentResult.Error(reason = "Неизвестный тип карты")
        }
    }
    fun show(result: PaymentResult) {
        when (result) {
            is PaymentResult.Success -> println("Успеx: ${result.id}-")
            is PaymentResult.Error -> println("Ошибка: ${result.reason}")
            PaymentResult.Processing -> println("B обработке...")
        }
    }
}
