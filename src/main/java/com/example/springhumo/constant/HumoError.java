package com.example.springhumo.constant;

import com.example.springhumo.model.Result;

import java.util.HashMap;
import java.util.Map;

public enum HumoError {
    error_000(0, "Approved", ApiResults.OK),
    error_001(1, "Approved, honour with identification", ApiResults.OK),
    error_002(2, "Approved for partial amount", ApiResults.OK),
    error_003(3, "Approved for VIP", ApiResults.OK),
    error_004(4, "Approved, update track 3", ApiResults.OK),
    error_005(5, "Approved, account type specified by card issuer", ApiResults.OK),
    error_006(6, "Approved for partial amount, account type specified by card issuer", ApiResults.OK),
    error_007(7, "Approved, update ICC", ApiResults.OK),
    error_100(100, "Decline (general, no comments)", ApiResults.ERR_080),
    error_101(101, "Decline, expired card", ApiResults.ERR_067),
    error_102(102, "Decline, suspected fraud", ApiResults.ERR_086),
    error_103(103, "Decline, card acceptor contact acquirer", ApiResults.ERR_027),
    error_104(104, "Decline, restricted card", ApiResults.ERR_083),
    error_105(105, "Decline, card acceptor call acquirer's security department", ApiResults.ERR_027),
    error_106(106, "Decline, allowable PIN tries exceeded", ApiResults.ERR_080),
    error_107(107, "Decline, refer to card issuer", ApiResults.ERR_068),
    error_108(108, "Decline, refer to card issuer's special conditions", ApiResults.ERR_068),
    error_109(109, "Decline, invalid merchant", ApiResults.ERR_103),
    error_110(110, "Decline, invalid amount", ApiResults.ERR_039),
    error_111(111, "Decline, invalid card number", ApiResults.ERR_117),
    error_112(112, "Decline, PIN data required", ApiResults.ERR_006),
    error_113(113, "Decline, unacceptable fee", ApiResults.ERR_042),
    error_114(114, "Decline, no account of type requested", ApiResults.ERR_001),
    error_115(115, "Decline, requested function not supported", ApiResults.ERR_001),
    error_116(116, "Decline, not sufficient funds", ApiResults.ERR_057),
    error_117(117, "Decline, incorrect PIN", ApiResults.ERR_116),
    error_118(118, "Decline, no card record", ApiResults.ERR_004),
    error_119(119, "Decline, transaction not permitted to cardholder", ApiResults.ERR_072),
    error_120(120, "Decline, transaction not permitted to terminal", ApiResults.ERR_103),
    error_121(121, "Decline, exceeds withdrawal amount limit", ApiResults.ERR_042),
    error_122(122, "Decline, security violation", ApiResults.ERR_001),
    error_123(123, "\"Decline, exceeds withdrawal frequency limit\nIf a contact interface with PIN pad is available, contactless terminals must immediately display an appropriate message to prompt for a contact transaction\"\n", ApiResults.ERR_080),
    error_124(124, "Decline, violation of law", ApiResults.ERR_001),
    error_125(125, "Decline, card not effective", ApiResults.ERR_083),
    error_126(126, "Decline, invalid PIN block", ApiResults.ERR_116),
    error_127(127, "Decline, PIN length error", ApiResults.ERR_116),
    error_128(128, "Decline, PIN kay synch error", ApiResults.ERR_116),
    error_129(129, "Decline, suspected counterfeit card", ApiResults.ERR_086),
    error_180(180, "Decline, by cardholders wish", ApiResults.ERR_086),
    error_200(200, "Pick-up (general, no comments)", ApiResults.ERR_001),
    error_201(201, "Pick-up, expired card", ApiResults.ERR_067),
    error_202(202, "Pick-up, suspected fraud", ApiResults.ERR_086),
    error_203(203, "Pick-up, card acceptor contact card acquirer", ApiResults.ERR_027),
    error_204(204, "Pick-up, restricted card", ApiResults.ERR_058),
    error_205(205, "Pick-up, card acceptor call acquirer's security department", ApiResults.ERR_027),
    error_206(206, "Pick-up, allowable PIN tries exceeded", ApiResults.ERR_080),
    error_207(207, "Pick-up, special conditions", ApiResults.ERR_077),
    error_208(208, "Pick-up, lost card", ApiResults.ERR_001),
    error_209(209, "Pick-up, stolen card", ApiResults.ERR_001),
    error_210(210, "Pick-up, suspected counterfeit card", ApiResults.ERR_001),
    error_300(300, "Status message: file action successful", ApiResults.ERR_001),
    error_301(301, "Status message: file action not supported by receiver", ApiResults.ERR_001),
    error_302(302, "Status message: unable to locate record on file", ApiResults.ERR_001),
    error_303(303, "Status message: duplicate record, old record replaced", ApiResults.ERR_001),
    error_304(304, "Status message: file record field edit error", ApiResults.ERR_001),
    error_305(305, "Status message: file locked out", ApiResults.ERR_001),
    error_306(306, "Status message: file action not successful", ApiResults.ERR_001),
    error_307(307, "Status message: file data format error", ApiResults.ERR_001),
    error_308(308, "Status message: duplicate record, new record rejected", ApiResults.ERR_001),
    error_309(309, "Status message: unknown file", ApiResults.ERR_001),
    error_400(400, "Accepted (for reversal)", ApiResults.ERR_001),
    error_499(499, "Approved, no original message data", ApiResults.ERR_001),
    error_500(500, "Status message: reconciled, in balance", ApiResults.ERR_001),
    error_501(501, "Status message: reconciled, out of balance", ApiResults.ERR_001),
    error_502(502, "Status message: amount not reconciled, totals provided", ApiResults.ERR_001),
    error_503(503, "Status message: totals for reconciliation not available", ApiResults.ERR_001),
    error_504(504, "Status message: not reconciled, totals provided", ApiResults.ERR_001),
    error_600(600, "Accepted (for administrative info)", ApiResults.ERR_001),
    error_601(601, "Status message: impossible to trace back original transaction", ApiResults.ERR_001),
    error_602(602, "Status message: invalid transaction reference number", ApiResults.ERR_001),
    error_603(603, "Status message: reference number/PAN incompatible", ApiResults.ERR_001),
    error_604(604, "Status message: POS photograph is not available", ApiResults.ERR_001),
    error_605(605, "Status message: requested item supplied", ApiResults.ERR_001),
    error_606(606, "Status message: request cannot be fulfilled - required documentation is not available", ApiResults.ERR_001),
    error_680(680, "List ready", ApiResults.ERR_001),
    error_681(681, "List not ready", ApiResults.ERR_001),
    error_700(700, "Accepted (for fee collection)", ApiResults.ERR_001),
    error_800(800, "Accepted (for network management)", ApiResults.ERR_001),
    error_900(900, "Advice acknowledged, no financial liability accepted", ApiResults.ERR_001),
    error_901(901, "Advice acknowledged, finansial liability accepted", ApiResults.ERR_001),
    error_902(902, "Decline reason message: invalid transaction", ApiResults.ERR_001),
    error_903(903, "Status message: re-enter transaction", ApiResults.ERR_001),
    error_904(904, "Decline reason message: format error", ApiResults.ERR_001),
    error_905(905, "Decline reason message: acqiurer not supported by switch", ApiResults.ERR_001),
    error_906(906, "Decline reason message: cutover in process", ApiResults.ERR_001),
    error_907(907, "Decline reason message: card issuer or switch inoperative", ApiResults.ERR_001),
    error_908(908, "Decline reason message: transaction destination cannot be found for routing", ApiResults.ERR_034),
    error_909(909, "Decline reason message: system malfunction", ApiResults.ERR_034),
    error_910(910, "Decline reason message: card issuer signed off", ApiResults.ERR_001),
    error_911(911, "Decline reason message: card issuer timed out", ApiResults.ERR_001),
    error_912(912, "Decline reason message: card issuer unavailable", ApiResults.ERR_001),
    error_913(913, "Decline reason message: duplicate transmission", ApiResults.ERR_001),
    error_914(914, "Decline reason message: not able to trace back to original transaction", ApiResults.ERR_001),
    error_915(915, "Decline reason message: reconciliation cutover or checkpoint error", ApiResults.ERR_001),
    error_916(916, "Decline reason message: MAC incorrect", ApiResults.ERR_001),
    error_917(917, "Decline reason message: MAC key sync error", ApiResults.ERR_001),
    error_918(918, "Decline reason message: no communication keys available for use", ApiResults.ERR_001),
    error_919(919, "Decline reason message: encryption key sync error", ApiResults.ERR_001),
    error_920(920, "Decline reason message: security software/hardware error - try again", ApiResults.ERR_001);

    private final String label;
    private final Integer Id;
    private final Result result;
    private static final Map<Integer, HumoError> map = new HashMap();

    public Integer getValue() {
        return this.Id;
    }

    private HumoError(Integer id, String label, Result result) {
        this.label = label;
        this.Id = id;
        this.result = result;
    }

    public static HumoError findById(int Id) {
        return (HumoError) map.getOrDefault(Id, error_100);
    }

    public String getLabel() {
        return this.label;
    }

    public Integer getId() {
        return this.Id;
    }

    public Result getResult() {
        return this.result;
    }

    static {
        HumoError[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            HumoError r = var0[var2];
            map.put(r.getId(), r);
        }

    }
}
