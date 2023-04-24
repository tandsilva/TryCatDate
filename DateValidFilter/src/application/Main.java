package application;

import models.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        //definiu o formato da data
        SimpleDateFormat sdf = new SimpleDateFormat("dd//MM//yyyy");
        System.out.println("Room number");

        int number =sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());

        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
//se nao chekout eh a negacao ,a variavel do tipo date tem um verificaco do tipo after que verifica as datas
        if(!checkOut.after(checkin)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number,checkin,checkOut);
            System.out.println(reservation);
        }


        sc.close();
    }
}