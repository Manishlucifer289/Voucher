package com.Voucher.Service.impl;

import com.Voucher.Entity.Voucher;
import com.Voucher.Payload.Voucherdto;
import com.Voucher.Repository.VoucherRepository;
import com.Voucher.Service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VoucherServiceimpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    @Override
    public Voucherdto createVoucher(Voucherdto voucherdto) {
        Voucher voucher =maptoEntity(voucherdto);
        Voucher saved = voucherRepository.save(voucher);
        Voucherdto dto = maptodto(saved);
        return dto;
    }

    @Override
    public void deleteVouchercode(long id) {
        voucherRepository.deleteById(id);

    }

    @Override
    public List<Voucherdto> fetchvoucherdetails() {
        List<Voucher> all = voucherRepository.findAll();
        List<Voucherdto> collect = all.stream().map(v -> maptodto(v)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Voucher updateVoucher(Voucher voucher, long id) {
        Optional<Voucher> byId = voucherRepository.findById(id);
        if(byId.isPresent()){
            Voucher updatedvoucher = byId.get();
            updatedvoucher.setVouchercode(voucher.getVouchercode());
            updatedvoucher.setVoucherdiscount(voucher.getVoucherdiscount());
            Voucher savedproduct= voucherRepository.save(updatedvoucher);
            return savedproduct;


        }else{
            throw new RuntimeException("voucher is not present in my db"+ id);
        }

    }

    Voucher maptoEntity(Voucherdto voucherdto){
        Voucher voucher = new Voucher();
        voucher.setVouchercode(voucherdto.getVouchercode());
        voucher.setVoucherdiscount(voucherdto.getVoucherdiscount());
        return voucher;
    }
    Voucherdto maptodto(Voucher voucher){
        Voucherdto dto = new Voucherdto();
        dto.setVouchercode(voucher.getVouchercode());
        dto.setVoucherdiscount(voucher.getVoucherdiscount());
        return dto;

    }

}
