package com.Voucher.Repository;

import com.Voucher.Entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher,Long> {
}
