package com.Voucher.Service;

import com.Voucher.Entity.Voucher;
import com.Voucher.Payload.Voucherdto;

import java.util.List;

public interface VoucherService {
    public Voucherdto createVoucher(Voucherdto voucherdto);
    public void deleteVouchercode(long id);

    public List<Voucherdto> fetchvoucherdetails();

    public Voucher updateVoucher(Voucher voucher, long id);
}
