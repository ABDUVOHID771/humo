package com.example.springhumo.service.local;

import java.util.Optional;

import com.example.springhumo.model.entity.Bank;
import com.example.springhumo.model.entity.BankBin;
import com.example.springhumo.model.entity.P2pBankHumo;
import com.example.springhumo.repository.BankBinRepository;
import com.example.springhumo.repository.BankRepository;
import com.example.springhumo.repository.P2pBankHumoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    private Logger logger = LogManager.getLogger(BankService.class);
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private BankBinRepository binRepository;
    @Autowired
    private P2pBankHumoRepository p2pBankHumoRepository;

    public BankService() {
    }

    public Optional<Bank> getBankByPan(String pan) {
        String bin = pan.substring(0, 6);
        return this.getBankByBin(bin);
    }

    public Optional<Bank> getBankByBin(String bin) {
        Optional<BankBin> bankBin = this.binRepository.findByBin(bin);
        return !bankBin.isPresent() ? Optional.empty() : Optional.of(((BankBin)bankBin.get()).getBank());
    }

    public Optional<Bank> getBankById(Integer id) {
        return this.bankRepository.findById(id);
    }

    public Optional<P2pBankHumo> getP2pBankByPan(String pan) {
        Optional<Bank> bank = this.getBankByPan(pan);
        if (!bank.isPresent()) {
            this.logger.warn("Bank not found for the given pan: " + pan);
            return Optional.empty();
        } else {
            return this.getP2pBankByBankId(((Bank)bank.get()).getBankId());
        }
    }

    public Optional<P2pBankHumo> getP2pBankByBankId(Integer bankId) {
        return this.p2pBankHumoRepository.findByBank_BankId(bankId);
    }
}
