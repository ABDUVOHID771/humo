package com.example.springhumo.service.local;

import java.util.ArrayList;
import java.util.List;

import com.example.springhumo.model.entity.Terminal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {
    @Value("${humo.terminal.id}")
    private String terminalId;
    @Value("${humo.terminal.merchant}")
    private String terminalMerchant;

    public TerminalService() {
    }

    public List<Terminal> getTerminalsForReconciliation() {
        List<Terminal> terminals = new ArrayList();
        terminals.add(this.getTerminal());
        return terminals;
    }

    public Terminal findById(String terminalId) {
        return this.getTerminal();
    }

    private Terminal getTerminal() {
        Terminal terminal = new Terminal();
        terminal.setMerchantId(this.terminalMerchant);
        terminal.setTerminalId(this.terminalId);
        return terminal;
    }
}
