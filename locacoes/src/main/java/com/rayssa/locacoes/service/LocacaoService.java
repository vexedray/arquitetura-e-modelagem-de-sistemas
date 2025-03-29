package com.rayssa.locacoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rayssa.locacoes.entities.Locacao;
import com.rayssa.locacoes.entities.Cliente;
import com.rayssa.locacoes.entities.Veiculo;
import com.rayssa.locacoes.repository.LocacaoRepository;
import com.rayssa.locacoes.repository.ClienteRepository;
import com.rayssa.locacoes.repository.VeiculoRepository;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    LocacaoRepository repository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    public ResponseEntity<String> cadastro(Locacao locacao) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(locacao.getCliente().getId());
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(locacao.getVeiculo().getId());

        if (clienteOpt.isPresent() && veiculoOpt.isPresent()) {
            long dias = ChronoUnit.DAYS.between(locacao.getDataRetirada().toInstant(),
                    locacao.getDataDevolucaoPrevista().toInstant());
            locacao.setDiasAlugados((int) dias); // Definindo o número de dias alugados
            double valorTotal = locacao.calcularValorTotal(); // Calculando o valor total
            locacao.setValorTotal(valorTotal);
            repository.save(locacao);
            return new ResponseEntity<>("Locação cadastrada com sucesso. Valor total: R$" + valorTotal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cliente ou Veículo não encontrado", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Locacao>> lista() {
        List<Locacao> locacoes = repository.findAll();
        return new ResponseEntity<>(locacoes, HttpStatus.OK);
    }
}
