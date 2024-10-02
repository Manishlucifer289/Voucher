package com.Voucher.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="voucher")
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String vouchercode;
    private int voucherdiscount;
    @OneToOne(mappedBy = "Voucher_id")
    private Payment payment;

}
