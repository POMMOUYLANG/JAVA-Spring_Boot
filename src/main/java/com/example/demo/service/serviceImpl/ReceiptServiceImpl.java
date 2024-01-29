package com.example.demo.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.demo.model.Receipt;
import com.example.demo.repository.ReceiptRepository;
import com.example.demo.service.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    private ReceiptRepository receiptRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository) {
        super();
        this.receiptRepository = receiptRepository;
    }

    
    @Override
    public Receipt saveReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }


    @Override
    public Receipt getReceiptById(Integer id) {
        return receiptRepository.findById(id).get();
    }
    
}
