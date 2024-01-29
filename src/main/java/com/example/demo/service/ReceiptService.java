package com.example.demo.service;

import com.example.demo.model.Receipt;

public interface ReceiptService {
    Receipt saveReceipt(Receipt receipt);
    Receipt getReceiptById(Integer id);
}
