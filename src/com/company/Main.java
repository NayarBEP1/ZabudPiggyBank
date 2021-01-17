package com.company;

import java.util.Scanner;

public class Main {

    int fiftyCoins = 0;
    int hundredCoins = 0;
    int twoHundredCoins = 0;
    int fiveHundredCoins = 0;
    int thousandCoins = 0;
    static boolean exit = false;

    // Se crea una instancia de esta misma clase (Main) para poder utilizar todos los métodos sin crearlos como estáticos
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            main.menu(scanner);
        }
    }

    private void menu(Scanner scanner) {
        String option;
        consoleSpace();
        System.out.println("¿Qué deseas realizar?");
        System.out.println("1. Ingresar dinero");
        System.out.println("2. Conocer la cantidad de monedas dentro de la alcancía");
        System.out.println("3. Conocer la cantidad de monedas por denominación");
        System.out.println("4. Conocer la cantidad de dinero por denominación");
        System.out.println("5. Conocer la cantidad de dinero en total");
        System.out.println("9. Salir");
        option = scanner.next();
        switch (option) {
            case "1":
                insertMoney(scanner);
                break;
            case "2":
                coinsInThePiggyBank();
                break;
            case "3":
                coinsPerDenomination();
                break;
            case "4":
                amountPerDenomination();
                break;
            case "5":
                totalAmount();
                break;
            case "9":
                System.out.println("Gracias por usar esta aplicació");
                System.out.println("¡Hasta Luego!");
                exit = true;
                break;
            default:
                System.out.println("Opción incorrecta");
        }
    }

    private void validateCoins(int coin, int amountOfCoins) {
        switch (coin) {
            case 50:
                this.fiftyCoins += amountOfCoins;
                break;
            case 100:
                this.hundredCoins += amountOfCoins;
                break;
            case 200:
                this.twoHundredCoins += amountOfCoins;
                break;
            case 500:
                this.fiveHundredCoins += amountOfCoins;
                break;
            case 1000:
                this.thousandCoins += amountOfCoins;
                break;
            default:
                System.out.println("Valor incorrecto, por favor ingresa un valor permitido, estos son 50, 100, 200, 500 ó 1000");
        }
    }

    private void insertMoney(Scanner scanner) {
        int coin = 0;
        int amountOfCoins = 0;
        boolean correctOption = false;
        String amount;
        while(!correctOption){
            try {
                System.out.println("Ingresa la cantidad de monedas que vayas a insertar de la misma denominación");
                amount = scanner.next();
                amountOfCoins = Integer.parseInt(amount);
                correctOption = true;
            } catch (Exception e) {
                System.out.println("Error, la cantidad de monedas no es permitida, recuerde que debe ingresar un valor numérico");
                correctOption = false;
            }
        }
        correctOption = false;
        while (!correctOption) {
            try {
                System.out.println("Ingresa la denominación de la moneda a ingresar, recuerda que debe ser de 50, 100, 200, 500 ó 1000");
                coin = scanner.nextInt();
                validateCoins(coin, amountOfCoins);
                correctOption = true;
            } catch (Exception e) {
                System.out.println("Inserta una moneda permitida, recuerda que son de $50, $100, $200, $500, $1000");
                correctOption = false;
            }
        }


    }

    private void coinsInThePiggyBank() {
        int coins = fiftyCoins + hundredCoins + twoHundredCoins + fiveHundredCoins + thousandCoins;
        System.out.println("En la alcancía hay una cantidad de " + coins + " monedas");
    }

    private void coinsPerDenomination() {
        consoleSpace();
        System.out.println("La cantidad de monedas por denominación son:");
        System.out.println(fiftyCoins + " monedas de $50");
        System.out.println(hundredCoins + " monedas de $100");
        System.out.println(twoHundredCoins + " monedas de $200");
        System.out.println(fiveHundredCoins + " monedas de $500");
        System.out.println(thousandCoins + " monedas de $1000");
    }

    private void amountPerDenomination() {
        consoleSpace();
        System.out.println("La cantidad de dinero por denominación es:");
        System.out.println("$" + (fiftyCoins * 50) + " en monedas de $50");
        System.out.println("$" + (hundredCoins * 100) + " en monedas de $100");
        System.out.println("$" + (twoHundredCoins * 200) + " en monedas de $200");
        System.out.println("$" + (fiveHundredCoins * 500) + " en monedas de $500");
        System.out.println("$" + (thousandCoins * 1000) + " en monedas de $1000");
    }

    private void totalAmount() {
        consoleSpace();
        int total = (fiftyCoins * 50) + (hundredCoins * 100) + (twoHundredCoins * 200) + (fiveHundredCoins * 500) + (thousandCoins * 1000);
        System.out.println("El total de dinero en la alcancía es: $" + total);
    }

    private void consoleSpace(){
        System.out.println("");
        System.out.println("");
    }
}
