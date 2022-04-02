# FreeClassJava
Esercizio Free Class Java: Applicazione per gestire studenti e corsi

# ISTRUZIONI PER AVVIARE L'APPLICAZIONE

Spostarsi in una delle cartelle creare in questo repository.

## DAL TERMINALE

### Prerequisiti

Avere installato nel proprio PC la `JDK 11` e avere nelle _variabili d'ambiente_ **Path** il percorso della
cartella `bin` della nostra JDK.

### AVVIO

Aprire il terminale e spostarsi nella cartella in cui abbiamo creato/scaricato il progetto. Fatto questo possiamo
eseguire i seguenti comandi:

- Su Windows:
   ```shell
   .\mvnw.cmd spring-boot:run
   
   oppure
   
   .\mvnw spring-boot:run
   ```
- Su Sistemi Unix:
   ```shell
   ./mvnw spring-boot:run
   ```

## DALL'IDE

Se abbiamo scaricato IntelliJ o STS eseguendo lo START la nostra applicazione funzionerà immediatamente. In caso
contrario creare la configurazione per eseguire un comando `maven` e come GOAL specificare `spring-boot:run`
