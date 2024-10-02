package com.Voucher.Controller;

import com.Voucher.Entity.Voucher;
import com.Voucher.Payload.Voucherdto;
import com.Voucher.Service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @PostMapping("/create")
    public ResponseEntity<String>createVouchercode(@RequestBody Voucherdto voucherdto){
        Voucherdto dto = voucherService.createVoucher(voucherdto);
        return new ResponseEntity<>("your record is saved", HttpStatus.CREATED);

    }
    @DeleteMapping("/delete")
    public ResponseEntity<String>deleteVouchercode(@PathVariable long id){
        voucherService.deleteVouchercode(id);
        return new ResponseEntity<>("your voucher is deleted",HttpStatus.OK);
    }
    @GetMapping("/fetch")
    public ResponseEntity<List<Voucherdto>>fetchalldetails(){
        List<Voucherdto> fetchvoucherdetails = voucherService.fetchvoucherdetails();
        return new ResponseEntity<>(fetchvoucherdetails,HttpStatus.OK);

    }
    @PutMapping("/update")
    public ResponseEntity<String>updateVoucher(@RequestBody Voucher voucher ,@PathVariable long id){
        Voucher updatedvoucher = voucherService.updateVoucher(voucher, id);
        return new ResponseEntity<>("your vouchere is updated", HttpStatus.OK);
    }


}
