import java.util.Scanner;

public class ATM {
    private double balance;

    public ATM() {
        this.balance = 0.0;
    }

    public void checkBalance() {
        System.out.println("Saldo actual: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Has depositado: $" + amount);
            checkBalance();
        } else {
            System.out.println("La cantidad a depositar debe ser mayor a 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Has retirado: $" + amount);
            checkBalance();
        } else if (amount > balance) {
            System.out.println("Fondos insuficientes.");
        } else {
            System.out.println("La cantidad a retirar debe ser mayor a 0.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nCajero Automático:");
            System.out.println("1. Verificar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Introduce la cantidad a depositar: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Introduce la cantidad a retirar: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Gracias por usar el cajero automático. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
