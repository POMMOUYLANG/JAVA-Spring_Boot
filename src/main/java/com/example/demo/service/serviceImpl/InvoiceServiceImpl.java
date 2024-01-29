package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        super();
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Integer getNewInvoiceNumber() {
        Integer newNumber = (int) invoiceRepository.count();
        while (newNumber > 100){
            newNumber = newNumber - 100;
        }
        newNumber = newNumber + 1;

        return newNumber;
    }

    @Override
    public Invoice saveInvoice( Invoice invoice) {
        return invoiceRepository.save(invoice);
    }


    @Override
    public Invoice getInvoiceById(Integer id) {
        return invoiceRepository.findById(id).get();
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
    
}
