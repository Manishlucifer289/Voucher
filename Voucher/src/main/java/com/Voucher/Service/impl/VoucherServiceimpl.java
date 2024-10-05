package com.Voucher.Service.impl;

import com.Voucher.Entity.Voucher;
import com.Voucher.Payload.Voucherdto;
import com.Voucher.Repository.VoucherRepository;
import com.Voucher.Service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceimpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    @Override
    public Voucherdto createvoucher(Voucherdto voucherdto) {
        Voucher voucher = maptoEntity(voucherdto);
        Voucher saved = voucherRepository.save(voucher);
        Voucherdto dto = maptodto(saved);
        return dto;
    }
    Voucher maptoEntity(Voucherdto voucherdto){
        Voucher voucher = new Voucher();
        voucher.setVouchercode(voucherdto.getVouchercode());
        voucher.setAmmount(voucherdto.getAmmount());
        return voucher;

    }
    Voucherdto maptodto(Voucher voucher){
        Voucherdto dto = new Voucherdto();
        dto.setVouchercode(voucher.getVouchercode());
        dto.setAmmount(voucher.getAmmount());
        return dto;
    }
}
