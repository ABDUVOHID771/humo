package com.example.springhumo.constant;

import java.util.HashMap;
import java.util.Map;

public enum TransactionType {
    REFILL("110", "C", "Пополнение счета"),
    TRANSFER_FROM_DEPOSIT_ACCOUNT("111", "C", "Перевод с депозитного счета"),
    OTHER_INCOMES("113", "C", "Прочие платежи (пополнения счета)"),
    REVERSE_WITH_CASH("114", "C", "Возврат (реверсал) аванса наличными"),
    OTHER_CREDIT_ADJUSTMENT("115", "C", "Прочая кредитная корректировка"),
    TRANSFER_TO_DEPOSIT_ACCOUNT("121", "D", "Перевод на депозитный счет"),
    REVERSE_MANUAL("124", "D", "Реверсал платежей (ручной)"),
    OTHER_DEBIT_ADJUSTMENT("125", "D", "Прочая дебетовая корректировка"),
    CASH_BACK("204", "D", "Кэш-бек"),
    P2P_SENT("205", "D", "Покупка/Платеж (P2P отправка)"),
    P2P_RECEIVED("206", "C", "Зачисление перевода (P2P зачисление)"),
    CASH_WITHDRAWAL("207", "D", "Снятие наличных"),
    REFILL_BY_CASH_IN_ATM("208", "C", "Пополнение счета через cash in банкомат"),
    PURCHASE_WITH_CASH_BACK("209", "D", "Покупка с кэшбеком"),
    REVERSE_P2P_SENT("225", "C", "Возврат (реверсал) покупки (205)"),
    REVERSE_P2P_RECEIVE("226", "D", "Возврат (реверсал) зачисления перевода (206)"),
    REVERSE_CASH_WITHDRAWAL("227", "C", "Возврат (реверсал) снятия наличных (207)"),
    REVERSE_REFILL_BY_CASH_IN_ATM("228", "D", "Возврат (реверсал) пополнения через cash-in (208)"),
    REVERSE_PURCHASE_WITH_CASH_BACK("229", "C", "Возврат (реверсал) покупки с кэшбеком (209)"),
    REVERSE_COMMISSION_FOR_CASH_WITHDRAWAL("314", "C", "Возврат (реверсал) комиссии за выдачу наличных (324)"),
    REVERSE_ANNUAL_PAYMENT("315", "C", "Возврат (реверсал) ежегодной платы (осн.комиссия) (325)"),
    REVERSE_CARD_CHANGE("316", "C", "Возврат (реверсал) платы за замену карты (326)"),
    COMMISSION_FOR_CASH_WITHDRAWAL("324", "D", "Комиссия за выдачу наличных"),
    ANNUAL_PAYMENT("325", "D", "Ежегодная плата (осн.комиссия)"),
    PAYMENT_FOR_CARD_CHANGE("326", "D", "Плата за замену карты"),
    LATE_PAYMENT("327", "D", "Просрочка платежа"),
    STATEMENT_FEE("328", "D", "Комиссия за выписку"),
    FOR_CHARITY("524", "D", "За благотворительность"),
    CHECKBOOK_REQUIREMENTS("614", "C", "Требования по чековой книжке"),
    REVERSE_INSTALLMENT_PAYMENT("11b", "C", "Рассрочка платежа в обратном порядке"),
    INSTALLMENT_INTEREST_IN_INSTALLMENT("11c", "C", "Рассрочка процентов в рассрочку"),
    CREDIT_PAYMENT("11C", "C", "Оплата (кредит)"),
    TRANSFER_FROM_CARD_ACCOUNT("11E", "C", "Денежный перевод с карточного счета"),
    BONUS("11G", "C", "Бонус"),
    WRITE_OFF_BAD_DEBITS("11L", "C", "Списание безнадежных долгов"),
    MANUAL_P2P_CREDIT_ACCOUNT("11V", "C", "Ручной перевод - кредитование счета (P2P с других систем)"),
    TYPE_12a("12a", "D", "Рассрочка кредита в рассрочку"),
    TYPE_12C("12C", "D", "Оплата (дебет)"),
    TYPE_12E("12E", "D", "Денежный перевод на карточный счет"),
    TYPE_12G("12G", "D", "Возврат (реверсал) бонуса"),
    TYPE_12j("12j", "D", "Обратная корректировка кредита в рассрочку"),
    TYPE_12P("12P", "D", "Плата за генерацию ПИН"),
    TYPE_12V("12V", "D", "Ручной перевод - дебетование счета (P2P на другие системы)"),
    TYPE_31a("31a", "C", "Возрат (реверсал) платы за обновление (перевыпуск) карты (доп.комиссия)"),
    TYPE_31A("31A", "C", "Возврат (реверсал) платы за обновление (перевыпуск) карты"),
    TYPE_31b("31b", "C", "Возврат (реверсал) платы за выпуск дубликата карты (доп.комиссия)"),
    TYPE_31B("31B", "C", "Отмена (реверсал) платы за выпуск дубликата карты"),
    TYPE_31D("31D", "C", "Комиссия за выпуск карты - обратная база"),
    TYPE_31E("31E", "C", "Возврат (реверсал) комиссии с покупки"),
    TYPE_31G("31G", "C", "Возврат (реверсал) комиссии за выдачу средств с банкомата"),
    TYPE_31g("31g", "C", "Обратный страховой взнос"),
    TYPE_31K("31K", "C", "Возврат (реверсал) комиссии за кэшбек"),
    TYPE_31R("31R", "C", "Возврат (реверсал) платы за выдачу дополнительной карты"),
    TYPE_31W("31W", "C", "Возврат комиссии Surcharge (сверх суммы) с банкомата и POS"),
    TYPE_32A("32A", "D", "Плата за обновление (перевыпуск) карты"),
    TYPE_32a("32a", "D", "Плата за обновление (перевыпуск) карты (доп.комиссия)"),
    TYPE_32d("32d", "D", "Плата за оформление чековой книжки"),
    TYPE_32e("32e", "D", "Плата за выписку по счету клиента"),
    TYPE_32F("32F", "D", "Плата за конвертацию валюты"),
    TYPE_32G("32G", "D", "Комиссия за выдачу с банкомата"),
    TYPE_32H("32H", "D", "Ежегодная плата (доплата)"),
    TYPE_32K("32K", "D", "Комиссия за кэшбек"),
    TYPE_32k("32k", "D", "Плата за запрос чековой книжки"),
    TYPE_32l("32l", "D", "Обратный депозит"),
    TYPE_32O("32O", "D", "Плата за неактивность карты (осн.комиссия)"),
    TYPE_32P("32P", "D", "Плата за неактивность карты (доп.комиссия)"),
    TYPE_32Q("32Q", "D", "Комиссия за обслуживание"),
    TYPE_32R("32R", "D", "Комиссия за выпуск дополнительной карты"),
    TYPE_32W("32W", "D", "Комиссия Surcharge (сверх суммы) с банкомата и POS"),
    TYPE_51a("51a", "C", "Сторнирование сборов за перепечатку устава"),
    TYPE_51c("51c", "C", "Возврат (реверсал) излишне переведенных средств"),
    TYPE_51G("51G", "C", "Возврат (реверсал) ежегодной платы (доп.комиссия)"),
    TYPE_52a("52a", "D", "Возврат реверсала"),
    TYPE_52b("52b", "D", "Сторнирование для списания"),
    TYPE_52c("52c", "D", "Сторнирование временного кредита"),
    TYPE_52d("52d", "D", "Сторнирование постоянного кредита"),
    TYPE_52H("52H", "D", "Отмена платежа за выдачу дубликата"),
    TYPE_52M("52M", "D", "Возврат (отмена) по чеку"),
    TYPE_52U("52U", "D", "Плата за выдачу дубликата выписки по счету");

    private final String code;
    private final String cOrD;
    private final String description;
    private static final Map<String, TransactionType> map = new HashMap();

    private TransactionType(String code, String cOrD, String description) {
        this.code = code;
        this.cOrD = cOrD;
        this.description = description;
    }

    public static TransactionType findById(int Id) {
        return (TransactionType) map.get(Id);
    }

    public String getCode() {
        return this.code;
    }

    public String getcOrD() {
        return this.cOrD;
    }

    public String getDescription() {
        return this.description;
    }

    static {
        TransactionType[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            TransactionType r = var0[var2];
            map.put(r.getCode(), r);
        }

    }
}
