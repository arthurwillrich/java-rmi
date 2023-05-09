# java-rmi

## **Laboratório 02 de Computação Distribuida - INE 5418**

Implementação uma aplicação usando invocação de método remota com Java RMI

## **Execução**
Passo a passo para execução do programa:

### **Pré-requisitos**

    JDK (Java Development Kit) instalado na máquina

#### **Passos**

Compile os arquivos do projeto:

```
javac CinemaServerImpl.java CinemaClient.java CinemaClientGUI.java TerminalClientCinema.java
```
Inicie o registro RMI:
```
rmiregistry
```

Inicie, em outro terminal, a aplicação cliente com interface gráfica:
```
java CinemaClient
```
Inicie, em outro terminal, a aplicação cliente em modo terminal:
```
java TerminalCinemaClient
```
