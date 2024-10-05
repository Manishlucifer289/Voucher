package com.Voucher.Payload;

import lombok.Data;

@Data
public class Voucherdto {
    private long id;
    private String vouchercode;
    private String ammount;
}
