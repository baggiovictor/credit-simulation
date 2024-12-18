package com.baggiovictor.creditsimulation.application.creditsimulation;

import com.baggiovictor.creditsimulation.application.creditsimulation.usecases.CreateInLotCreditSimulationUseCase;
import com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationRepository;
import java.time.Period;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Serviço responsável por processar em lote simulações de crédito de forma paralela. Ele divide a
 * lista de comandos em lotes menores e processa cada lote utilizando várias threads para melhorar a
 * performance.
 */
@AllArgsConstructor
@Service
public class CreateInLotCreditSimulationAppService implements CreateInLotCreditSimulationUseCase {

  private final CreditSimulationRepository repository;

  /**
   * Tamanho do lote para o processamento paralelo das simulações de crédito.
   */
  private static final int BATCH_SIZE = 10000;

  /**
   * ExecutorService com um pool fixo de 4 threads para executar o processamento em paralelo.
   */
  private final ExecutorService executorService = Executors.newFixedThreadPool(4);

  /**
   * Executa o processamento em lote de simulações de crédito. O método divide a lista de comandos
   * em lotes menores e processa cada lote utilizando múltiplas threads para melhorar a
   * performance.
   *
   * @param commandList Lista de comandos de criação de simulação de crédito
   */
  @Override
  public void execute(List<CreateInLotCreditSimulationCommand> commandList) {
    long startTime = System.currentTimeMillis();

    int totalSimulations = commandList.size();
    int numberOfBatches = (int) Math.ceil((double) totalSimulations / BATCH_SIZE);

    // Divisão da lista de comandos em lotes e execução paralela
    for (int i = 0; i < numberOfBatches; i++) {
      int start = i * BATCH_SIZE;
      int end = Math.min(start + BATCH_SIZE, totalSimulations);

      List<CreateInLotCreditSimulationCommand> batch = commandList.subList(start, end);

      executorService.submit(() -> processBatch(batch));
    }

    // Marca o tempo final e calcula a duração
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    System.out.println("Tempo de execução total: " + duration + "ms");
  }

  /**
   * Processa um lote de comandos de simulação de crédito. Para cada comando no lote, cria uma nova
   * simulação de crédito e a persiste no repositório.
   *
   * @param batch Lote de comandos de criação de simulação de crédito
   */
  private void processBatch(List<CreateInLotCreditSimulationCommand> batch) {
    for (CreateInLotCreditSimulationCommand command : batch) {
      var anAge = Period.between(command.customerBirthDate(), LocalDate.now()).getYears();

      CreditSimulation aCreditSimulation = CreditSimulation.newCreditSimulation(
          command.amount(),
          command.termInMonths(),
          anAge,
          command.type(),
          command.name(),
          command.email()
      );

      repository.save(CreditSimulationEntity.from(aCreditSimulation));
    }
  }
}
