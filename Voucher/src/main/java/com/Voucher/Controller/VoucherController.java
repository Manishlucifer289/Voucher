package com.Voucher.Controller;

import com.Voucher.Payload.Voucherdto;
import com.Voucher.Service.VoucherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
    @RequestMapping("/api/v1/voucher")
    public class VoucherController {
        private VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @PostMapping("/create")
        public ResponseEntity<String> createvoucher(@RequestBody Voucherdto voucherdto){
            Voucherdto createvoucher = voucherService.createvoucher(voucherdto);
            return new ResponseEntity<>("your voucher is created" , HttpStatus.CREATED);


        }
    }


